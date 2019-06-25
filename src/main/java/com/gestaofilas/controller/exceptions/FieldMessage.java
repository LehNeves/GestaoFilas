package com.gestaofilas.controller.exceptions;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FieldMessage.
 */
public class FieldMessage implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The field name. */
	private String fieldName;
	
	/** The message. */
	private String message;
	
	/**
	 * Instancia um novo campo de mensagem.
	 */
	public FieldMessage() {
	}

	/**
	 * Instancia um novo campo de mensagem.
	 *
	 * @param fieldName the field name
	 * @param message the message
	 */
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	/**
	 * Pega o nome do campo.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Define o nome do campo.
	 *
	 * @param fieldName the new field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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
