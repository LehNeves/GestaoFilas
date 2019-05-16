package com.gestaofilas.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestaofilas.controller.exceptions.FieldMessage;
import com.gestaofilas.dao.RestauranteDAO;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.dto.RestauranteNewDTO;
import com.gestaofilas.services.validation.utils.BR;

public class RestauranteInsertValidator implements ConstraintValidator<RestauranteInsert, RestauranteNewDTO> {

	@Autowired
	private RestauranteDAO repo;
	
	@Override
	public void initialize(RestauranteInsert ann) {
	}

	@Override
	public boolean isValid(RestauranteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (!BR.isValidCNPJ(objDto.getCnpj())) {
			list.add(new FieldMessage("cnpj", "CNPJ inválido"));
		}
		
		if (repo.findByCnpj(objDto.getCnpj())) {
			list.add(new FieldMessage("cnpj", "CNPJ já existente"));
		}
		
		Restaurante aux = repo.findByEmail(objDto.getEmail());
		
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

