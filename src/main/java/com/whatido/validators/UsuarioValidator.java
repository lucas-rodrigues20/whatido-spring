package com.whatido.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.Usuario;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class UsuarioValidator implements Validator {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!errors.hasErrors()){
			Usuario usuario = (Usuario) target;
			
			if(usuarioDAO.buscarPorEmail(usuario.getEmail()) != null){
				errors.rejectValue("email", "usuario.email.existe");
			}
		}
	}

}
