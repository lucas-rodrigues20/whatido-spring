package com.whatido.utils;

public enum TipoEmail {
	
	CADASTRO ("cadastro.ftl"),
	NOVASENHA ("novaSenha.ftl"),
	RECUPERARSENHA ("recuperarSenha.ftl"),
	CONTATO ("contato.ftl");
	
	private String descricao;

	private TipoEmail(String descricao) {
		this.descricao = descricao;	
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
