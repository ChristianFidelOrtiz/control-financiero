package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.TipoDeDocumento;
import com.example.demo.repositories.TipoDeDocumentoRepository;
import com.example.demo.services.TipoDeDocumentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoDeDocumentoServiceImpl implements TipoDeDocumentoService {

	private final TipoDeDocumentoRepository repository;
	
	@Override
	public List<TipoDeDocumento> getAlls() {

		return repository.findByAll();
	}

	@Override
	public Optional<TipoDeDocumento> getById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void save(TipoDeDocumento tdd) {
		this.repository.save(tdd);
	}

	@Override
	public void delete(Long id) {

		if (Objects.nonNull(id)) {
			this.repository.findById(id).ifPresent(tdd -> this.repository.delete(tdd));
		}
	}

}
