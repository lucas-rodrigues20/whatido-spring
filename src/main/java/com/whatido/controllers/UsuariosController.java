package com.whatido.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.TipoPermissao;
import com.whatido.models.filtro.FiltroUsuario;

@Controller
@RequestMapping("/usuarios")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class UsuariosController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listaUsuarios(FiltroUsuario filtroUsuario){
		ModelAndView modelAndView = new ModelAndView("usuario/usuarios");
		
		modelAndView.addObject("permissoes", TipoPermissao.values());
		
		List<Object[]> usuarios = usuarioDAO.buscaFiltrada(filtroUsuario);
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView buscaUsuarios(FiltroUsuario filtroUsuario, RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("filtroUsuario", filtroUsuario);
		return new ModelAndView("redirect:/usuarios");
	}
	
}
