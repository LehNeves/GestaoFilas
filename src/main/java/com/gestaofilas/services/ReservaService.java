package com.gestaofilas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaofilas.services.exceptions.ObjectNotFoundException;
import com.gestaofilas.dao.ReservaDAO;
import com.gestaofilas.entity.Reserva;


@Service
public class ReservaService {

	@Autowired
	ReservaDAO repo;
	
	public Reserva findById(Integer id) {
		Optional<Reserva> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Reserva.class.getName()));
	}
	
	public List<Reserva> findAll() {
		return repo.findAll();
	}
	
	public Page<Reserva> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Reserva save (Reserva obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Reserva update(Reserva obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		Reserva obj = findById(id);
		repo.deleteById(obj.getId());
	}
}
