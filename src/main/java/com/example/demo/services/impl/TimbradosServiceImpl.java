
package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Timbrados;
import com.example.demo.repositories.TimbradosRepository;
import com.example.demo.services.TimbradosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TimbradosServiceImpl implements TimbradosService {

	private final TimbradosRepository repository;
	
	@Override
	public List<Timbrados> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<Timbrados> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(Timbrados timbrado) {
		this.repository.save(timbrado);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(timbrado -> this.repository.delete(timbrado));
		}
	}

}
