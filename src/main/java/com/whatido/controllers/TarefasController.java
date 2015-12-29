package com.whatido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.whatido.daos.ListasDAO;
import com.whatido.models.ListaTarefas;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {

	@Autowired
	private ListasDAO listasDAO;
	
	@RequestMapping("/{id}")
	public ModelAndView tarefas(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("/tarefas/detalhe");
		
		ListaTarefas todasAsTarefas = listasDAO.listarTodasAsTarefas(id);
		modelAndView.addObject("lista", todasAsTarefas);
		
		return modelAndView;
	}
	
}
