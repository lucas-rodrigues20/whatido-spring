package com.whatido.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import com.whatido.models.NovaSenha;
import com.whatido.utils.SegurancaUtils;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class NovaSenhaValidator implements Validator {
	
	@Autowired
	private SegurancaUtils segurancaUtils;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaSenha.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senhaAtual", "field.required.novaSenha.senhaAtual");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "novaSenha", "field.required.novaSenha.novaSenha");
		
		NovaSenha novaSenha = (NovaSenha) target;
		if(!segurancaUtils.getUsuarioLogado().getSenha().equals(novaSenha.getSenhaAtual())){
			errors.rejectValue("senhaAtual", "novaSenha.senhaAtual.incorreta");
		}
		
	}

}
