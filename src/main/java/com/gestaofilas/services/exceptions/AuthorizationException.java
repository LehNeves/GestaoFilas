package com.gestaofilas.services.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Classe AuthorizationException.
 */
public class AuthorizationException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instancia uma nova exceção de autorização.
	 *
	 * @param msg the msg
	 */
	public AuthorizationException(String msg) {
		super(msg);
	}
	
	/**
	 * Instancia uma nova exceção de autorização.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
