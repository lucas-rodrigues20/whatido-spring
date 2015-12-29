package com.whatido.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatido.models.ListaTarefas;

@Repository
@Transactional
public class ListasDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(ListaTarefas listaTarefas){
		manager.persist(listaTarefas);
	}

	public List<ListaTarefas> listar() {
		return manager.createQuery("from ListaTarefas", ListaTarefas.class).getResultList();
	}

	public void remover(Integer listaId) {
		ListaTarefas lista = manager.find(ListaTarefas.class, listaId);
		manager.remove(lista);
		manager.flush();
	}
	
	public ListaTarefas listarTodasAsTarefas(Integer listaId){
		return manager.createQuery("select l from ListaTarefas l join fetch l.tarefas t where l.id = :id",
				ListaTarefas.class)
				.setParameter("id", listaId)
				.getSingleResult();
	}
	
}
