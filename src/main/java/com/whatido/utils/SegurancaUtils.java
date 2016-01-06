package com.whatido.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.whatido.models.Usuario;
import com.whatido.models.UsuarioSpring;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class SegurancaUtils {
	
	public Usuario getUsuarioLogado(){
		
		if(isUsuarioLogado()){
			UsuarioSpring usuarioLogado = (UsuarioSpring) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			return usuarioLogado.getUsuario();
		}
		
		return null;
	}
	
	public boolean isUsuarioLogado(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return principal != null && !principal.equals("anonymousUser");
	}
	
}
