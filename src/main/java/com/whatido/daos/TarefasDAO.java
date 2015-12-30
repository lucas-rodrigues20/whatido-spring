package com.whatido.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatido.models.Tarefas;

@Repository
@Transactional
public class TarefasDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Tarefas tarefas){
		manager.merge(tarefas);
	}
	
	public void remover(Integer id){
		Tarefas tarefa = manager.find(Tarefas.class, id);
		manager.remove(tarefa);
		manager.flush();
	}
	
}
