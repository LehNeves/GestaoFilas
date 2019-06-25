package com.gestaofilas.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationError.
 */
public class ValidationError extends StandardError {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The errors. */
	private List<FieldMessage> errors = new ArrayList<>();
	
	/**
	 * Instancia uma nova validação de erro.
	 *
	 * @param timestamp the timestamp
	 * @param status the status
	 * @param message the message
	 * @param path the path
	 */
	public ValidationError(Long timestamp, Integer status, String message, String path) {
		super(timestamp, status, message, path);
	}

	/**
	 * Pega o erro.
	 *
	 * @return the errors
	 */
	public List<FieldMessage> getErrors() {
		return errors;
	}

	/**
	 * Adiciona o erro.
	 *
	 * @param fieldName the field name
	 * @param message the message
	 */
	public void addErrors(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}