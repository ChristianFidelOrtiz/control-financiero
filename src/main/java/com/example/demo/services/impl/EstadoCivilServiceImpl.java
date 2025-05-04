package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.EstadoCivil;
import com.example.demo.repositories.EstadoCivilRepository;
import com.example.demo.services.EstadoCivilService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstadoCivilServiceImpl implements EstadoCivilService {

	private final EstadoCivilRepository repository;
	
	@Override
	public List<EstadoCivil> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<EstadoCivil> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(EstadoCivil ec) {
		this.repository.save(ec);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(ec -> this.repository.delete(ec));
		}
	}

}