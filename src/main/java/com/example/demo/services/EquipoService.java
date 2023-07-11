package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Equipo;
import com.example.demo.repositories.EquipoRepository;

@Service
public class EquipoService {

	@Autowired
	EquipoRepository acRepo;

	public ArrayList<Equipo> obtenerEquipos() {
		return (ArrayList<Equipo>) acRepo.findAll();
	}

	public ArrayList<Equipo> obtenerAperturasCuenta(Long clId) {
		return (ArrayList<Equipo>) acRepo.findByclId(clId);
	}

	public Equipo guardarAperturaCuenta(Equipo ac) {
		return acRepo.save(ac);
	}

	public Optional<Equipo> obtenerAperturaCuentaPorId(Long id) {
		return acRepo.findById(id);
	}

	public boolean eliminarAperturaCuenta(Long id) {
		try {
			acRepo.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
}
