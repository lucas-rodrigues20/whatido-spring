package com.whatido.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Tarefas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String descricao;
	
	private Boolean concluida = Boolean.FALSE;
	
	@ManyToOne
	private ListaTarefas lista;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//getters e setters
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ListaTarefas getLista() {
		return lista;
	}
	public void setLista(ListaTarefas lista) {
		this.lista = lista;
	}
	
	public Boolean getConcluida() {
		return concluida;
	}
	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}
	
	//Métodos
	public void inverterEstadoFinalizacao(){
		if(this.concluida == Boolean.TRUE){
			this.concluida = Boolean.FALSE;
		}else{
			this.concluida = Boolean.TRUE;
		}
	}
	
}
