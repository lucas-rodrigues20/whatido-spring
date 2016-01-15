package com.whatido.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.NovaSenha;
import com.whatido.models.Usuario;
import com.whatido.utils.SegurancaUtils;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class NovaSenhaValidator implements Validator {
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaSenha.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!errors.hasErrors()){
			NovaSenha novaSenha = (NovaSenha) target;
			Usuario usuario = usuarioDAO.buscarPorEmail(segurancaUtils.getUsuarioLogado().getEmail());
			
			if(!usuario.getSenha().equals(novaSenha.getSenhaAtual())){
				errors.rejectValue("senhaAtual", "novaSenha.senhaAtual.incorreta");
			}
		}
	}

}
