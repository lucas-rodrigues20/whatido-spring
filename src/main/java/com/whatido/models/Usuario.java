package com.whatido.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private TipoPermissao permissao = TipoPermissao.ROLE_USER;
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<ListaTarefas> listaTarefas;
	
	//getters e setters	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public TipoPermissao getPermissao() {
		return permissao;
	}
	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}
	
	public List<ListaTarefas> getListaTarefas() {
		return listaTarefas;
	}
	public void setListaTarefas(List<ListaTarefas> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
	
	//métodos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}
