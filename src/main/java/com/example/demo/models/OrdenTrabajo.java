package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idorden", unique = true, nullable = false)	
	private Long orId;
	@Column(name = "fecha", nullable = false)
	private Date orFecha;
	@Column(name = "descripcion", nullable = false)
	private String orDescripcion;
	@Column(name = "equipoid", nullable = false)
	private Long eqId;
	
}
