package com.whatido.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.whatido.models.Usuario;
import com.whatido.models.filtro.FiltroUsuario;

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
	
	public Usuario atualizar(Usuario usuario){
		return manager.merge(usuario);
	}
	
	public Usuario alterarSenha(Usuario usuario, String senha){
		usuario = buscarPorEmail(usuario.getEmail());
		usuario.setSenha(senha);
		
		return atualizar(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> buscaFiltrada(FiltroUsuario filtro){
		Session session = manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.createAlias("listaTarefas", "l", JoinType.LEFT_OUTER_JOIN);		
		
		ProjectionList colunasNecessarias = Projections.projectionList();
		colunasNecessarias.add(Projections.property("nome"));
		colunasNecessarias.add(Projections.property("email"));
		colunasNecessarias.add(Projections.property("permissao"));
		colunasNecessarias.add(Projections.count("l.usuario"));
		
		colunasNecessarias.add(Projections.groupProperty("l.usuario.email"));
		
		criteria.setProjection(colunasNecessarias);
		
		if(filtro.getFiltro() != null || !StringUtils.isEmpty(filtro.getFiltro())){
			Criterion nome = Restrictions.ilike("nome", filtro.getFiltro(), MatchMode.ANYWHERE);
			Criterion email = Restrictions.ilike("email", filtro.getFiltro(), MatchMode.ANYWHERE);
			
			criteria.add(Restrictions.or(nome, email));
		}
		
		if(filtro.getPermissao() != null || !StringUtils.isEmpty(filtro.getPermissao())){
			criteria.add(Restrictions.eq("permissao", filtro.getPermissao()));
		}
		
		criteria.addOrder(Order.asc("nome"));
		
		return criteria.list();
		
	}

}
