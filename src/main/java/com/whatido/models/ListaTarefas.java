package com.whatido.models;

public class ListaTarefas {
	
	private Integer id;
	
	private String descricao;
	
	//getters e setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "ListaTarefas [id=" + id + ", descricao=" + descricao + "]";
	}

}
