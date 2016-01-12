package com.whatido.daos;

import java.util.List;

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
	
	public Usuario buscarPorEmail(String email){
		List<Usuario> resultList = manager.createQuery("from Usuario u where u.email = :email", Usuario.class)
			.setParameter("email", email)
			.getResultList();
		
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}
		
		return null;
	}
	
	public void atualizar(Usuario usuario){
		manager.merge(usuario);
	}
	
	public void alterarSenha(Usuario usuario, String senha){
		usuario = buscarPorEmail(usuario.getEmail());
		usuario.setSenha(senha);
		
		atualizar(usuario);
	}
	
}
