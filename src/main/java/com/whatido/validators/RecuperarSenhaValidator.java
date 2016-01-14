package com.whatido.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.RecuperarSenha;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class RecuperarSenhaValidator implements Validator {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return RecuperarSenha.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!errors.hasErrors()){
			RecuperarSenha recuperarSenha = (RecuperarSenha) target;
			
			if(usuarioDAO.buscarPorEmail(recuperarSenha.getEmail()) == null){
				errors.rejectValue("email", "recuperarSenha.email.inexistente");
			}
		}
	}

}
