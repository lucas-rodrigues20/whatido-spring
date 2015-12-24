package com.whatido.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.whatido.daos.ListasDAO;
import com.whatido.models.ListaTarefas;

@Controller
@RequestMapping("/listas")
public class ListasController {
	
	@Autowired
	private ListasDAO listasDAO;
	
	@RequestMapping("/form")
	public ModelAndView form(ListaTarefas listaTarefas){
		ModelAndView modelAndView = new ModelAndView("listas/form");
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid ListaTarefas listaTarefas, BindingResult result){
		if(result.hasErrors()){
			return form(listaTarefas);
		}
		
		System.out.println(listaTarefas);
		listasDAO.gravar(listaTarefas);
		
		return new ModelAndView("redirect:listas/form");
	}

}
