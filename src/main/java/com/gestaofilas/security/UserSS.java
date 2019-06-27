package com.gestaofilas.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gestaofilas.entity.enums.Perfil;

// TODO: Auto-generated Javadoc
/**
 * Classe UserSS.
 */
public class UserSS implements UserDetails {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The email. */
	private String email;
	
	/** The senha. */
	private String senha;
	
	/** The authorities. */
	private Collection<? extends GrantedAuthority> authorities;
	
	/**
	 * Instancia um novo usuario SS.
	 */
	public UserSS() {
	}
	
	/**
	 * Instancia um novo usuario SS.
	 *
	 * @param id the id
	 * @param email the email
	 * @param senha the senha
	 * @param perfis the perfis
	 */
	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	/**
	 * Pega o id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Pega as autoridades.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * Pega a senha.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return senha;
	}

	/**
	 * Pega o username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return email;
	}

	/**
	 * Checa se a conta não expirou.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checa se a conta não esta trancada.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checa se a credencial não expirou.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Verifica se está ativada.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	/**
	 * Checks for role.
	 *
	 * @param perfil the perfil
	 * @return true, if successful
	 */
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
