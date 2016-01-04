package com.whatido.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public ModelAndView form(Usuario usuario){
		return new ModelAndView("/usuario/cadastro");
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
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
