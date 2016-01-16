package com.whatido.controllers;

import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whatido.models.Contato;
import com.whatido.utils.EnviadorEmail;

@Controller
@RequestMapping("/contato")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class MensagemContatoController {
	
	@Autowired
	private EnviadorEmail enviadorEmail;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(Contato contato){
		return new ModelAndView("contatoForm");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Callable<ModelAndView> enviar(@Valid final Contato contato, final BindingResult result,
			final RedirectAttributes redirectAttributes){
		
		return new Callable<ModelAndView>() {

			@Override
			public ModelAndView call() throws Exception {
				if(result.hasErrors()){
					return form(contato);
				}
				
				enviadorEmail.enviarEmailContato(contato);
				
				redirectAttributes.addFlashAttribute("mensagem", "Sua mensagem foi enviada.");
				return new ModelAndView("redirect:/contato");
				
			}
		};
	}

}
