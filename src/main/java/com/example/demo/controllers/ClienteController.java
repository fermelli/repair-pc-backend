package com.example.demo.controllers;

import java.text.ParseException;
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

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("cliente")

public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping()
	public ArrayList<Cliente> obtenerClientes(){
		return this.clienteService.obtenerClientes();
	}
	
	@PostMapping()
	public Cliente guardarCliente(@RequestBody Cliente cliente) throws ParseException {
		//System.out.println("fecha -> "+cliente.getCliFechaNacimiento());
		return this.clienteService.guardarCliente(cliente);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Cliente> obtenerClientePorId(@PathVariable("id") Long id){
		return this.clienteService.obtenerClientePorId(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public boolean eliminarCliente(@PathVariable("id") Long id) {
		return this.clienteService.eliminarCliente(id);
	}
}
