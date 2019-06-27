package com.gestaofilas.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.gestaofilas.security.UserSS;

// TODO: Auto-generated Javadoc
/**
 * Classe UserService.
 */
public class UserService {
	
	/**
	 * Autenticado.
	 *
	 * @return the user SS
	 */
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
