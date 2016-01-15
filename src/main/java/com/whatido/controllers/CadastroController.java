package com.whatido.controllers;

import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.Usuario;
import com.whatido.utils.EnviadorEmail;
import com.whatido.utils.SegurancaUtils;
import com.whatido.utils.TipoEmail;
import com.whatido.validators.UsuarioValidator;

@Controller
@RequestMapping("/cadastro")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CadastroController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@Autowired
	private UsuarioValidator usuarioValidator;
	
	@Autowired
	private EnviadorEmail enviadorEmail;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(usuarioValidator);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(Usuario usuario){
		if(segurancaUtils.isUsuarioLogado()){			
			return new ModelAndView("redirect:/");
		}else{
			return new ModelAndView("/usuario/cadastro");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Callable<ModelAndView> gravar(@Valid final Usuario usuario, final BindingResult result,
			final RedirectAttributes redirectAttributes){
		
		return new Callable<ModelAndView>() {

			@Override
			public ModelAndView call() throws Exception {
				if(result.hasErrors()){
					return form(usuario);
				}
				
				usuarioDAO.gravar(usuario);
				enviadorEmail.enviarEmailUsuario(usuario, "Cadastro Realizado", TipoEmail.CADASTRO);
				
				redirectAttributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso.");
				return new ModelAndView("redirect:/cadastro");
			}
		};
	}
	
}
