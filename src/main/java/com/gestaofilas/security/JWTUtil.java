package com.gestaofilas.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * Classe JWTUtil.
 */
@Component
public class JWTUtil {
	
	/** The secret. */
	@Value("${jwt.secret}")
	private String secret;

	/** The expiration. */
	@Value("${jwt.expiration}")
	private Long expiration;
	
	/**
	 * Gera um token.
	 *
	 * @param username the username
	 * @return the string
	 */
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
	/**
	 * Token valido.
	 *
	 * @param token the token
	 * @return true, if successful
	 */
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Pega o username.
	 *
	 * @param token the token
	 * @return the username
	 */
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	/**
	 * Recebe as reivindicações.
	 *
	 * @param token the token
	 * @return the claims
	 */
	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch (Exception e) {
			return null;
		}
	}
}
