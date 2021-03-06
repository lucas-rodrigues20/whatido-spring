package com.whatido.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whatido.daos.ListasDAO;
import com.whatido.daos.TarefasDAO;
import com.whatido.models.ListaTarefas;
import com.whatido.models.Tarefas;
import com.whatido.utils.SegurancaUtils;

@Controller
@RequestMapping("/tarefas")
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class TarefasController {

	@Autowired
	private ListasDAO listasDAO;
	
	@Autowired
	private TarefasDAO tarefasDAO;
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	private ListaTarefas lista;
	
	@RequestMapping("/{id}")
	public ModelAndView tarefas(@PathVariable("id") Integer id, Tarefas tarefas){
		ModelAndView modelAndView = new ModelAndView("/tarefas/detalhe");
		
		lista = listasDAO.listarTodasAsTarefas(id);
		
		if(lista != null && lista.isListaPertencenteAoUsuarioLogado(segurancaUtils.getUsuarioLogado())){
			ArrayList<Tarefas> tarefasFinalizadas = lista.filtrarTarefasPeloEstadoDeFinalizacao(true);
			ArrayList<Tarefas> tarefasNaoFinalizadas = lista.filtrarTarefasPeloEstadoDeFinalizacao(false);
			
			modelAndView.addObject("listaTarefas", lista);
			modelAndView.addObject("tarefasFinalizadas", tarefasFinalizadas);
			modelAndView.addObject("tarefasNaoFinalizadas", tarefasNaoFinalizadas);
			return modelAndView;
		}else{
			return new ModelAndView("redirect:/listas");
		}
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView novaTarefa(@Valid Tarefas tarefas, BindingResult result,
			RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return tarefas(lista.getId(), tarefas);
		}
		
		tarefas.setLista(lista);
		tarefasDAO.gravar(tarefas);
		
		redirectAttributes.addFlashAttribute("mensagem", "Tarefa adicionada com sucesso.");
		return new ModelAndView("redirect:/tarefas/" + lista.getId());
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Integer id, RedirectAttributes redirectAttributes){
		if(lista.getUltimaTarefaSorteada().getId() == id){
			lista.setUltimaTarefaSorteada(null);
			listasDAO.gravar(lista);
		}
		tarefasDAO.remover(id);
		
		redirectAttributes.addFlashAttribute("mensagem", "Tarefa removida com sucesso.");
		return new ModelAndView("redirect:/tarefas/" + lista.getId());
	}
	
	@RequestMapping("/finalizar")
	public ModelAndView finalizar(Integer id, RedirectAttributes redirectAttributes){
		Tarefas tarefa = tarefasDAO.buscar(id);
		tarefa.inverterEstadoFinalizacao();
		tarefasDAO.gravar(tarefa);
		
		redirectAttributes.addFlashAttribute("mensagem", "Tarefa finalizada.");
		return new ModelAndView("redirect:/tarefas/" + lista.getId());
	}
	
	@RequestMapping("/sortear")
	public ModelAndView sortear(RedirectAttributes redirectAttributes){
		lista.sortear();
		listasDAO.gravar(lista);
		
		redirectAttributes.addFlashAttribute("mensagem", "Tarefa sorteada.");
		return new ModelAndView("redirect:/tarefas/" + lista.getId());
	}
	
}
