package com.whatido.controllers;

import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.NovaSenha;
import com.whatido.models.Usuario;
import com.whatido.utils.EnviadorEmail;
import com.whatido.utils.SegurancaUtils;
import com.whatido.utils.TipoEmail;
import com.whatido.validators.NovaSenhaValidator;

@Controller
@RequestMapping("/usuario")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class AlterarSenhaController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@Autowired
	private NovaSenhaValidator novaSenhaValidator;
	
	@Autowired
	private EnviadorEmail enviadorEmail;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(novaSenhaValidator);
	}
	
	@RequestMapping(value="/alterarSenha", method=RequestMethod.GET)
	public ModelAndView form(NovaSenha novaSenha){
		return new ModelAndView("usuario/alterarSenha");
	}
	
	@RequestMapping(value="/alterarSenha", method=RequestMethod.POST)
	public Callable<ModelAndView> alterarSenha(@Valid final NovaSenha novaSenha, final BindingResult result,
			final RedirectAttributes redirectAttributes){
		
		return new Callable<ModelAndView>() {

			@Override
			public ModelAndView call() throws Exception {
				if(result.hasErrors()){
					return form(novaSenha);
				}
				
				Usuario usuario = usuarioDAO.alterarSenha(segurancaUtils.getUsuarioLogado(), novaSenha.getNovaSenha());
				enviadorEmail.enviarEmailUsuario(usuario, "Sua Senha Foi Alterada", TipoEmail.NOVASENHA);
				
				redirectAttributes.addFlashAttribute("mensagem", "Senha alterada com sucesso.");
				return new ModelAndView("redirect:/usuario/alterarSenha");
			}
		};
	}

}
