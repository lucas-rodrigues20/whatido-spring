package com.whatido.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatido.models.ListaTarefas;
import com.whatido.models.Usuario;

@Repository
@Transactional
public class ListasDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(ListaTarefas listaTarefas){
		manager.merge(listaTarefas);
	}

	public List<ListaTarefas> listar(Usuario usuario) {
		return manager.createQuery("from ListaTarefas l left join fetch l.usuario where l.usuario.email = :pEmail", ListaTarefas.class)
				.setParameter("pEmail", usuario.getEmail())
				.getResultList();
	}

	public void remover(Integer listaId) {
		ListaTarefas lista = manager.find(ListaTarefas.class, listaId);
		manager.remove(lista);
		manager.flush();
	}
	
	public ListaTarefas listarTodasAsTarefas(Integer listaId){
		List<ListaTarefas> resultList = manager.createQuery("from ListaTarefas l left join fetch l.usuario left join fetch l.tarefas left join fetch l.ultimaTarefaSorteada where l.id = :id",
				ListaTarefas.class)
				.setParameter("id", listaId)
				.getResultList();
		
		return resultList.get(0);
	}
	
}
