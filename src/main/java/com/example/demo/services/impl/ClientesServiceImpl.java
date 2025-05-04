package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Clientes;
import com.example.demo.repositories.ClientesRepository;
import com.example.demo.services.ClientesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {

	private final ClientesRepository repository;
	
	@Override
	public List<Clientes> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Clientes> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Clientes rol) {
		this.repository.save(rol);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(rol -> this.repository.delete(rol));
		}
	}

}
