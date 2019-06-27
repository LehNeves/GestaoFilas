package com.gestaofilas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.UsuarioDAO;
import com.gestaofilas.entity.Usuario;
import com.gestaofilas.security.UserSS;

// TODO: Auto-generated Javadoc
/**
 * Classe UserDetailsServiceImpl.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	/** The repo. */
	@Autowired
	private UsuarioDAO repo;

	/**
	 * Carrega user pelo username.
	 *
	 * @param email the email
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario obj = repo.findByEmail(email);
		
		if(obj == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
	}

}
