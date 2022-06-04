package com.example.demo.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Lavadora")
@Entity
public class Lavadora implements Serializable {


	private static final long serialVersionUID = 4933364708262943014L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLavadora;	
	private String descripcion;	
	private String marca;
	private String voltaje;
}
