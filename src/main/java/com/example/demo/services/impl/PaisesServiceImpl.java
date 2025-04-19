package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Paises;
import com.example.demo.repositories.PaisesRepository;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class PaisesServiceImpl implements PaisesService {

	private final PaisesRepository repository;
	
	@Override
	public List<Paises> getAlls() {
	
		return repository.findByAll();
	}

	@Override
	public Optional<Paises> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(Paises rol) {
		this.repository.save(rol);

	}

	@Override
	public void delete(Long id) {
		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(rol -> this.repository.delete(rol));

	}

}}
