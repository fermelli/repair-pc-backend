package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.OrdenTrabajo;
import com.example.demo.repositories.OrdenTrabajoRepository;

@Service
public class OrdenTrabajoService {

	@Autowired
	OrdenTrabajoRepository ccRepo;

	public ArrayList<OrdenTrabajo> obtenerOrdenesTrabajo() {
		return (ArrayList<OrdenTrabajo>) ccRepo.findAll();
	}

	public ArrayList<OrdenTrabajo> obtenerCuentasCorrientes(Long eqId) {
		return (ArrayList<OrdenTrabajo>) ccRepo.findByeqId(eqId);
	}

	public OrdenTrabajo guardarCuentaCorriente(OrdenTrabajo cc) {
		return ccRepo.save(cc);
	}

	public Optional<OrdenTrabajo> obtenerCuentaCorrientePorId(Long id) {
		return ccRepo.findById(id);
	}

	public boolean eliminarCuentaCorriente(Long id) {
		try {
			ccRepo.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
}
