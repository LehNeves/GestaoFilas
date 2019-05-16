package com.gestaofilas.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaofilas.dao.ClienteDAO;
import com.gestaofilas.dao.EnderecoClienteDAO;
import com.gestaofilas.dao.TelClienteDAO;
import com.gestaofilas.entity.Cidade;
import com.gestaofilas.entity.Cliente;
import com.gestaofilas.entity.EnderecoCliente;
import com.gestaofilas.entity.TelefoneCliente;
import com.gestaofilas.entity.dto.ClienteNewDTO;
import com.gestaofilas.entity.dto.ClienteUpdateDTO;
import com.gestaofilas.services.exceptions.DataIntegrityException;
import com.gestaofilas.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteDAO clienteRepo;
	
	@Autowired
	TelClienteDAO telefoneRepo;
	
	@Autowired
	EnderecoClienteDAO enderecoRepo;
	
	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepo.findAll(pageRequest);
	}
	
	
	public Cliente insert(ClienteNewDTO obj) {
		Cliente cliente = new Cliente(obj);
				
		EnderecoCliente enderecoCliente = new EnderecoCliente(obj);
		Cidade cidade = new Cidade(obj.getCidade(), null, null);
		enderecoCliente.setCidade(cidade);
		cliente.setEndereco(enderecoCliente);
		
		TelefoneCliente telefoneCliente = new TelefoneCliente(null, obj.getDdd(), obj.getTelefone());
		telefoneCliente.setCliente(cliente);
		cliente.setTelefone(telefoneCliente);
		
		enderecoRepo.save(enderecoCliente);
		cliente = clienteRepo.save(cliente);
		telefoneRepo.save(telefoneCliente);

		return cliente;
	}
	
	public void update(ClienteUpdateDTO objDto) {
		Cliente obj = findById(objDto.getId());
		obj = updateData(obj, objDto);
		clienteRepo.save(obj);
	}
	
	public Cliente updateData(Cliente obj, ClienteUpdateDTO objDto) {
		obj.setNome(objDto.getNome());
		obj.setEmail(objDto.getEmail());
		obj.setEndereco(objDto.getEndereco());
		obj.setTelefone(objDto.getTelefone());
		
		return obj;
	}
	
	public void delete(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);

		if(obj.get().getReservas().isEmpty()) {
			clienteRepo.deleteById(id);
		}else {
			throw new DataIntegrityException("Este Cliente não pode ser deletado");
		}
		
	}
	
}
