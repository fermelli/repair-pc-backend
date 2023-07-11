package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.OrdenTrabajo;
import com.example.demo.services.OrdenTrabajoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("ordenTrabajo")

public class OrdenTrabajoController {

	@Autowired
	OrdenTrabajoService ccService;
	
	@GetMapping(path = "/{eqId}")
	public ArrayList<OrdenTrabajo> obtenerCuentasCorrientes(@PathVariable("eqId") Long eqId){
		return this.ccService.obtenerCuentasCorrientes(eqId);
	}
	
	@PostMapping()
	public OrdenTrabajo guardarCuentaCorriente(@RequestBody OrdenTrabajo cc) {
		return this.ccService.guardarCuentaCorriente(cc);
	}
	
	@DeleteMapping(path = "/{id}")
	public String eliminarCuentaCorriente(@PathVariable("id") Long id) {
		boolean ok = this.ccService.eliminarCuentaCorriente(id);
		if(ok) {
			return "Se elimino la cuenta corriente con id "+id;
		}
		else {
			return "No se pudo eliminar la cuenta corriente con id "+id;
		}
	}
}
