package com.gestaofilas.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gestaofilas.services.exceptions.AuthorizationException;
import com.gestaofilas.services.exceptions.DataIntegrityException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ControllerExceptionHandler.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * Objeto não encontrado.
	 *
	 * @param e the e
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	/**
	 * Integridade de dados.
	 *
	 * @param e the e
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	/**
	 * Validação.
	 *
	 * @param e the e
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validantion(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro de validação", request.getRequestURI());
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addErrors(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	/**
	 * Autorização.
	 *
	 * @param e the e
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
}
