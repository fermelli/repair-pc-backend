package com.example.demo.models;

//import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcliente", unique = true, nullable = false)
	private Long clId;
	@Column(name = "ci", nullable = false)
	private Long clCi;
	@Column(name = "nombre", nullable = false)
	private String clNombre;
	@Column(name = "apellidos")
	private String clApellidos;
	@Column(name = "telefono", nullable = false)
	private Long clTelefono;
	@Column(name = "direccion", nullable = false)
	private String clDireccion;
	@OneToMany
	@JoinColumn (name="idcliente")
	@JsonIgnore
	private List<Equipo> equipos;
	
	public String getNombre() {
		return (this.clId+" "+this.clApellidos);
	}	
}
