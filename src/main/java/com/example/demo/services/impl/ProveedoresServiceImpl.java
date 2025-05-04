package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Proveedores;
import com.example.demo.repositories.ProveedoresRepository;
import com.example.demo.services.ProveedoresService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProveedoresServiceImpl implements ProveedoresService {

	private final ProveedoresRepository repository;
	
	@Override
	public List<Proveedores> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Proveedores> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Proveedores rol) {
		this.repository.save(rol);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(rol -> this.repository.delete(rol));
		}
	}

}