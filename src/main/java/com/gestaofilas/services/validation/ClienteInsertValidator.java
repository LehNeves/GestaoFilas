package com.gestaofilas.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestaofilas.controller.exceptions.FieldMessage;
import com.gestaofilas.dao.ClienteDAO;
import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.dto.ClienteNewDTO;
import com.gestaofilas.services.validation.utils.BR;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteInsertValidator.
 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	/** The repo. */
	@Autowired
	private ClienteDAO repo;
	
	/**
	 * Inicializar.
	 *
	 * @param ann the ann
	 */
	@Override
	public void initialize(ClienteInsert ann) {
	}

	/**
	 * Checa se é válido.
	 *
	 * @param objDto the obj dto
	 * @param context the context
	 * @return true, if is valid
	 */
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (!BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF inválido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		Cliente aux2 = repo.findByCpf(objDto.getCpf());
		if(aux2 != null) {
			list.add(new FieldMessage("cpf", "cpf já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}

