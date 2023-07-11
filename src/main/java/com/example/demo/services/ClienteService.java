package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;
	
	public ArrayList<Cliente> obtenerClientes(){
		return (ArrayList<Cliente>)clienteRepo.findAll();
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Optional<Cliente> obtenerClientePorId(Long id){
		return clienteRepo.findById(id);
	}
	
	public boolean eliminarCliente(Long id) {
		try {
			clienteRepo.deleteById(id);
			return true;
		} catch(Exception err) {
			return false;
		}
	}
}
