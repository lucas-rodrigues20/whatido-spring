package com.whatido.daos;

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
	
}
