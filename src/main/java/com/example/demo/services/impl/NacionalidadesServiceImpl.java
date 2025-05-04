package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Nacionalidades;
import com.example.demo.repositories.NacionalidadesRepository;
import com.example.demo.services.NacionalidadesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NacionalidadesServiceImpl implements NacionalidadesService {

	private final NacionalidadesRepository repository;
	
	@Override
	public List<Nacionalidades> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Nacionalidades> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Nacionalidades nacionalidad) {
		this.repository.save(nacionalidad);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(nacionalidad -> this.repository.delete(nacionalidad));
		}
	}

}
