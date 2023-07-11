package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Equipo;
import com.example.demo.services.EquipoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("equipo")

public class EquipoController {

	@Autowired
	EquipoService acService;

	@GetMapping()
	public ArrayList<Equipo> obtenerEquipos() {
		return this.acService.obtenerEquipos();
	}

	@GetMapping(path = "/{clId}")
	public ArrayList<Equipo> obtenerAperturaCuentas(@PathVariable("clId") Long clId) {
		return this.acService.obtenerAperturasCuenta(clId);
	}

	@GetMapping(path = "/apc/{id}")
	public Optional<Equipo> obtenerAperturaCuentaPorId(@PathVariable("id") Long id) {
		return this.acService.obtenerAperturaCuentaPorId(id);
	}

	@PostMapping()
	public Equipo guardarAperturaCuenta(@RequestBody Equipo ac) {
		return this.acService.guardarAperturaCuenta(ac);
	}

	@DeleteMapping(path = "/{id}")
	public String eliminarAperturaCuenta(@PathVariable("id") Long id) {
		boolean ok = this.acService.eliminarAperturaCuenta(id);
		if (ok) {
			return "Se elimino la apertura de cuenta con id " + id;
		} else {
			return "No se pudo eliminar la apertura de cuenta con id " + id;
		}
	}
}
