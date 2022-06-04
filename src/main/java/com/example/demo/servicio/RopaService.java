package com.example.demo.servicio;

import java.util.List;

import com.example.demo.dto.RopaRequestDTO;
import com.example.demo.dto.RopaResponseDTO;
import com.example.demo.modelo.Ropa;

public interface RopaService {

	public void guardarRopa(RopaRequestDTO p);
	public void eliminarRopa(Integer id);
	public void editarRopa(RopaRequestDTO p);
	List<RopaResponseDTO> listar();
	public Ropa RopaById(Integer id);
}
