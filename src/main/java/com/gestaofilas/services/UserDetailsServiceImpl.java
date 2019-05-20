package com.gestaofilas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gestaofilas.dao.ClienteDAO;
import com.gestaofilas.entity.Cliente;
import com.gestaofilas.security.UserSS;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private ClienteDAO clienteRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente obj = clienteRepo.findByEmail(email);
		if(obj == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
	}

}
