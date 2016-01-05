package com.whatido.conf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.whatido.daos.UsuarioDAO;
import com.whatido.models.Usuario;
import com.whatido.models.UsuarioSpring;

@Component
public class LoginDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public UsuarioSpring loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.buscarPorEmail(email);
		
		if(usuario != null){
			UsuarioSpring usuarioSpring = new UsuarioSpring(usuario, getNivelPermissao(usuario));
			
			return usuarioSpring;
		}
		else{
			throw new UsernameNotFoundException("Usuário " + email + " não foi encontrado");
		}
		
	}
	
	private Collection<? extends GrantedAuthority> getNivelPermissao(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(usuario.getPermissao().toString()));
		
		return authorities;
	}

}
