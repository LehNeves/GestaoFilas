package com.gestaofilas.controller.exceptions;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class StandardError.
 */
public class StandardError implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The timestamp. */
	private Long timestamp;
	
	/** The status. */
	private Integer status;
	
	/** The message. */
	private String message;
	
	/**
	 * Instancia um novo erro padrão.
	 *
	 * @param timestamp the timestamp
	 * @param status the status
	 * @param message the message
	 * @param path the path
	 */
	public StandardError(Long timestamp, Integer status, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
	}

	/**
	 * Pega o timestamp.
	 *
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * Define o timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Pega o status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Define o status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Pega a mensagem.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Define a mensagem.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
