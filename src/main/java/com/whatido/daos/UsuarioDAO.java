package com.whatido.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whatido.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Usuario usuario){
		manager.persist(usuario);
	}
	
}
