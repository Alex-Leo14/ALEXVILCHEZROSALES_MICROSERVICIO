package com.example.demo.servicio;

import java.util.List;

import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.modelo.Cliente;


public interface ClienteService {
	
		
	public void guardarCliente(ClienteRequestDTO p);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClienteRequestDTO p);
	List<ClienteResponseDTO> listar();
	public Cliente clienteById(Integer id);

}
