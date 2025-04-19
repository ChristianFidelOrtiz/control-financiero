package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Ciudades;
import com.example.demo.repositories.CiudadesRepository;
import com.example.demo.services.CiudadesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadesServiceImpl implements CiudadesService {

	private final CiudadesRepository repository;
	
	@Override
	public List<Ciudades> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Ciudades> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Ciudades rol) {
		this.repository.save(rol);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(rol -> this.repository.delete(rol));
		}
	}

}
