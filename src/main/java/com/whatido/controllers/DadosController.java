package com.whatido.controllers;

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

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.Usuario;
import com.whatido.utils.SegurancaUtils;

@Controller
@RequestMapping("/usuario")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class DadosController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@RequestMapping(value="/dados" ,method=RequestMethod.GET)
	public ModelAndView form(Usuario usuario){
		ModelAndView modelAndView = new ModelAndView("usuario/dados");
		
		if(usuario == null || usuario.getEmail() == null){			
			usuario = usuarioDAO.buscarPorEmail(segurancaUtils.getUsuarioLogado().getEmail());
			modelAndView.addObject("usuario", usuario);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/dados", method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result,
			RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return form(usuario);
		}
		
		usuario.setEmail(segurancaUtils.getUsuarioLogado().getEmail());
		usuario.setSenha(segurancaUtils.getUsuarioLogado().getSenha());
		usuarioDAO.atualizar(usuario);
		
		redirectAttributes.addFlashAttribute("mensagem", "Dados atualizados com sucesso.");
		return new ModelAndView("redirect:/dados");
	}
	
}
