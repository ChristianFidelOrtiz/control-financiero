package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Mercaderias;

public interface MercaderiasService {

	List<Mercaderias> getAlls();   	// usa al repositorio

	Optional<Mercaderias> getById(Long id);	// Busca una mercadería por su ID. Devuelve un Optional porque puede o no existir.

	void save(Mercaderias mercaderia);	// recibe un objeto completo de tipo Mercaderias. El save() toma todo el objeto y lo guarda en la base de datos con repository.save(mercaderia)

	void delete(Long id);	// Elimina una mercadería por su ID.
}
