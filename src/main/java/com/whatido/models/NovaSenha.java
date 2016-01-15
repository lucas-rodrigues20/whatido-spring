package com.whatido.models;

import org.hibernate.validator.constraints.NotBlank;

public class NovaSenha {
	
	@NotBlank
	private String senhaAtual;
	
	@NotBlank
	private String novaSenha;
	
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	
	public String getNovaSenha() {
		return novaSenha;
	}
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

}
