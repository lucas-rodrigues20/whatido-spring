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

import com.whatido.daos.ListasDAO;
import com.whatido.models.ListaTarefas;
import com.whatido.utils.SegurancaUtils;

@Controller
@RequestMapping("/listas")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ListasController {
	
	@Autowired
	private ListasDAO listasDAO;
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(ListaTarefas listaTarefas){
		ModelAndView modelAndView = new ModelAndView("listas/form");
		modelAndView.addObject("listas", listasDAO.listar());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid ListaTarefas listaTarefas, BindingResult result,
			RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return form(listaTarefas);
		}
		
		listasDAO.gravar(listaTarefas);
		
		redirectAttributes.addFlashAttribute("mensagem", "Lista cadastrada com sucesso.");
		return new ModelAndView("redirect:listas");
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Integer id, RedirectAttributes redirectAttributes){
		listasDAO.remover(id);
		
		redirectAttributes.addFlashAttribute("mensagem", "Lista removida com sucesso.");
		return new ModelAndView("redirect:/listas");
	}

}
