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
@Table(name = "equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idequipo", unique = true, nullable = false)
	private Long eqId;
	@Column(name = "modelo", nullable = false)
	private String eqModelo;
	@Column(name = "marca", nullable = false)
	private String eqMarca;
	@Column(name = "detalle", nullable = false)
	private String eqDetalle;
	@Column(name = "idcliente", nullable = false)
	private Long clId;
	@OneToMany
	@JoinColumn(name = "idequipo")
	@JsonIgnore
	private List<OrdenTrabajo> orden;
}
