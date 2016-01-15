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
import com.whatido.models.RecuperarSenha;
import com.whatido.models.Usuario;
import com.whatido.utils.EnviadorEmail;
import com.whatido.utils.SegurancaUtils;
import com.whatido.utils.TipoEmail;
import com.whatido.validators.RecuperarSenhaValidator;

@Controller
@RequestMapping("/usuario")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class RecuperarSenhaController {
	
	@Autowired
	private SegurancaUtils segurancaUtils;
	
	@Autowired
	private RecuperarSenhaValidator recuperarSenhaValidator;
	
	@Autowired
	private EnviadorEmail enviadorEmail;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(recuperarSenhaValidator);
	}
	
	@RequestMapping(value="/recuperarSenha", method=RequestMethod.GET)
	public ModelAndView form(RecuperarSenha recuperarSenha){
		if(segurancaUtils.isUsuarioLogado()){			
			return new ModelAndView("redirect:/");
		}else{
			return new ModelAndView("usuario/recuperarSenha");
		}
	}
	
	@RequestMapping(value="/recuperarSenha", method=RequestMethod.POST)
	public Callable<ModelAndView> recuperarSenha(@Valid final RecuperarSenha recuperarSenha, final BindingResult result,
			final RedirectAttributes redirectAttributes){
		
		return new Callable<ModelAndView>() {

			@Override
			public ModelAndView call() throws Exception {
		
				if(result.hasErrors()){
					return form(recuperarSenha);
				}
				
				Usuario usuario = usuarioDAO.buscarPorEmail(recuperarSenha.getEmail());
				enviadorEmail.enviarEmailUsuario(usuario, "Dados Recuperados", TipoEmail.RECUPERARSENHA);
				
				redirectAttributes.addFlashAttribute("mensagem", "Seus dados de acesso foram enviados para seu email.");
				return new ModelAndView("redirect:/usuario/recuperarSenha");
				
			}
		};
	}
	
}
