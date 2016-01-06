package com.whatido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.whatido.utils.SegurancaUtils;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class LoginController {
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(){
		if(segurancaUtils.isUsuarioLogado()){			
			return "redirect:/";
		}else{
			return "loginForm";
		}
	}
	
}
