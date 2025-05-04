package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Marcas;
import com.example.demo.repositories.MarcasRepository;
import com.example.demo.services.MarcasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarcasServiceImpl implements MarcasService {

	private final MarcasRepository repository;
	
	@Override
	public List<Marcas> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Marcas> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Marcas rol) {
		this.repository.save(rol);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(rol -> this.repository.delete(rol));
		}
	}

}