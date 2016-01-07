package com.whatido.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class ListaTarefas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String descricao;
	
	@OneToMany(mappedBy="lista", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Tarefas> tarefas = new ArrayList<Tarefas>();
	
	@OneToOne(optional=true, fetch=FetchType.LAZY)
	private Tarefas ultimaTarefaSorteada;
	
	@ManyToOne
	private Usuario usuario;
	
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
	
	public void setTarefas(List<Tarefas> tarefas) {
		this.tarefas = tarefas;
	}
	public List<Tarefas> getTarefas() {
		return tarefas;
	}
	
	public Tarefas getUltimaTarefaSorteada() {
		return ultimaTarefaSorteada;
	}
	public void setUltimaTarefaSorteada(Tarefas ultimaTarefaSorteada) {
		this.ultimaTarefaSorteada = ultimaTarefaSorteada;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "ListaTarefas [id=" + id + ", descricao=" + descricao + "]";
	}
	
	public void sortear(){
		List<Tarefas> lista = new ArrayList<>(this.tarefas);
		
		lista.remove(this.ultimaTarefaSorteada);
		lista = removerTarefasConcluidasDoSorteio(lista);
		
		if(!lista.isEmpty()){
			Collections.shuffle(lista);
			this.ultimaTarefaSorteada = lista.get(0);
		}
	}
	
	private List<Tarefas> removerTarefasConcluidasDoSorteio(List<Tarefas> lista) {
		for(Iterator<Tarefas> i = lista.iterator(); i.hasNext();){
			Tarefas item = i.next();
			
			if(item.isTarefaConcluida()){
				i.remove();
			}
		}
		
		return lista;
	}

}
