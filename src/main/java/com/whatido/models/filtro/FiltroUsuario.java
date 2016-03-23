package com.whatido.models.filtro;

import com.whatido.models.TipoPermissao;

public class FiltroUsuario {

	private String filtro;
	private TipoPermissao permissao;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	public TipoPermissao getPermissao() {
		return permissao;
	}
	public void setPermissao(TipoPermissao permissao) {
		this.permissao = permissao;
	}
	
}
