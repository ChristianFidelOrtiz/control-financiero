package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Ciudades;

public interface CiudadesService {

	List<Ciudades> getAlls();

	Optional<Ciudades> getById(Long id);

	void save(Ciudades rol);

	void delete(Long id);
}
