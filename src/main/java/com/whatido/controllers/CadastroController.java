package com.whatido.controllers;

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
import com.whatido.utils.SegurancaUtils;
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
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return form(usuario);
		}
		
		usuarioDAO.gravar(usuario);
		
		redirectAttributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso.");
		return new ModelAndView("redirect:/usuario/cadastro");
	}
	
}
