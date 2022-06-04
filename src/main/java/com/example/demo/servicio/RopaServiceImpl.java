package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.RopaRequestDTO;
import com.example.demo.dto.RopaResponseDTO;
import com.example.demo.modelo.Ropa;
import com.example.demo.modelo.Ropa;
import com.example.demo.repository.RopaRepository;


public class RopaServiceImpl implements RopaService {

	@Autowired
	private RopaRepository repository;
	@Override
	public void guardarRopa(RopaRequestDTO p) {
		Ropa Ropa = new Ropa();
		Ropa.setDescripcion(p.getDescripcion());
		Ropa.setTipoRopa(p.getTipoRopa());
		
		repository.save(Ropa);
		
	}

	@Override
	public void eliminarRopa(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarRopa(RopaRequestDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RopaResponseDTO> listar() {
		List<Ropa> Ropa = repository.findAll();
		List<RopaResponseDTO> dto = new ArrayList<RopaResponseDTO>();
		RopaResponseDTO RopaDTO = null;
		
		for (Ropa c : Ropa) {
			RopaDTO = new RopaResponseDTO();
			RopaDTO.setIdRopaResp(c.getIdRopa());
			RopaDTO.setTipoRopa(c.getTipoRopa());
			RopaDTO.setDescripcion(c.getDescripcion());
			
			dto.add(RopaDTO);
		}
		
		return dto;
	}

	@Override
	public Ropa RopaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
