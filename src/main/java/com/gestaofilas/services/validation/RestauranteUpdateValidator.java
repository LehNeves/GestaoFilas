package com.gestaofilas.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.gestaofilas.controller.exceptions.FieldMessage;
import com.gestaofilas.dao.RestauranteDAO;
import com.gestaofilas.entity.Restaurante;
import com.gestaofilas.entity.dto.RestauranteUpdateDTO;

public class RestauranteUpdateValidator implements ConstraintValidator<RestauranteUpdate, RestauranteUpdateDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	RestauranteDAO repo;
	
	@Override
	public void initialize(RestauranteUpdate ann) {
	}

	@Override
	public boolean isValid(RestauranteUpdateDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Restaurante aux = repo.findByEmail(objDto.getEmail());
		
		if (aux != null && !aux.getId().equals(uriId)) {
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

