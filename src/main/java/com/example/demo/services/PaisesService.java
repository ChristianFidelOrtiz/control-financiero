package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Paises;

public interface PaisesService {

	List<Paises> getAlls();

	Optional<Paises> getById(Long id);

	void save(Paises rol);

	void delete(Long id);
}
