package com.gestaofilas.services.exceptions;

// TODO: Auto-generated Javadoc
/**
 * Classe DataIntegrityException.
 */
public class DataIntegrityException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instancia uma nova exeção de integridade de dados.
	 *
	 * @param msg the msg
	 */
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	/**
	 * Instancia uma nova exeção de integridade de dados.
	 *
	 * @param msg the msg
	 * @param cause the cause
	 */
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
