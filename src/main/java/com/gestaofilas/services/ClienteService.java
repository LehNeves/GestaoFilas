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
		cliente.setTelefones(Arrays.asList(telefoneCliente));
		
		if(obj.getDdd2() != null) {
			TelefoneCliente telefoneCliente2 = new TelefoneCliente(null, obj.getDdd2(), obj.getTelefone2());
			telefoneCliente2.setCliente(cliente);
			cliente.setTelefones(Arrays.asList(telefoneCliente2));
		}
		
		enderecoRepo.save(enderecoCliente);
		cliente = clienteRepo.save(cliente);
		telefoneRepo.save(telefoneCliente);

		return cliente;
	}
	
	public Cliente update(Cliente obj) {
		Cliente persist = findById(obj.getId());
		obj = updateData(obj, persist);
		
		return clienteRepo.save(obj);
	}
	
	public Cliente updateData(Cliente obj, Cliente persist) {
		persist.setNome(obj.getNome());
		persist.setEmail(obj.getEmail());
		persist.setEndereco(obj.getEndereco());
		persist.setTelefones(persist.getTelefones());
		
		return persist;
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
