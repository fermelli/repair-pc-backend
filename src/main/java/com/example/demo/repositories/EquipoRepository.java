package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Equipo;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Long> {
	
	public abstract ArrayList<Equipo> findByclId(Long clId);
	
}
