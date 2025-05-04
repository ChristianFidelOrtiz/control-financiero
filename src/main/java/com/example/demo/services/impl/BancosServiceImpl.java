
package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Bancos;
import com.example.demo.repositories.BancosRepository;
import com.example.demo.services.BancosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BancosServiceImpl implements BancosService {

	private final BancosRepository repository;
	
	@Override
	public List<Bancos> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Bancos> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Bancos rol) {
		this.repository.save(rol);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(rol -> this.repository.delete(rol));
		}
	}

}
