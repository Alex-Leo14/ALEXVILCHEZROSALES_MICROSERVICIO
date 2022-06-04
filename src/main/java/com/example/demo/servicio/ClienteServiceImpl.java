package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<ClienteResponseDTO> listar(){
		List<Cliente> cliente = repository.findAll();
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDTO = null;
		
		for (Cliente c : cliente) {
			clienteDTO = new ClienteResponseDTO();
			clienteDTO.setIdClienteResp(c.getIdCliente());
			clienteDTO.setNombreCliente(c.getNombreCliente());
			clienteDTO.setApellidoCliente(c.getApellidoCliente());
			clienteDTO.setNroCelular(c.getNroCelular());
			clienteDTO.setDireccion(c.getDireccion());
			dto.add(clienteDTO);
		}
		
		return dto;
	}

	@Override
	public void guardarCliente(ClienteRequestDTO p) {
		Cliente cliente = new Cliente();
		cliente.setNombreCliente(p.getNombreCliente());
		cliente.setApellidoCliente(p.getApellidoCliente());
		cliente.setNroCelular(p.getNroCelular());
		cliente.setDireccion(p.getDireccion());
		repository.save(cliente);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarCliente(ClienteRequestDTO p) {
		Cliente cliente = new Cliente();
		//cliente = new ClienteResponseDTO();
		cliente.setIdCliente(p.getIdClienteReq());
		cliente.setNombreCliente(p.getNombreCliente());
		cliente.setApellidoCliente(p.getApellidoCliente());
		cliente.setNroCelular(p.getNroCelular());
		cliente.setDireccion(p.getDireccion());
		repository.save(cliente);
		
	}

	@Override
	public Cliente clienteById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	

}
