package com.example.demo.servicio;

import java.util.List;
import com.example.demo.modelo.Lavadora;

public interface LavadoraService  {
	
	public void guardarLavadora(Lavadora p);
	public void eliminarLavadora(Integer id);
	public void editarLavadora(Lavadora p);
	List<Lavadora> listar();
	public Lavadora LavadoraById(Integer id);
}
