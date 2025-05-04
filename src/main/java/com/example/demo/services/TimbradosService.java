package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Timbrados;

public interface TimbradosService {

	List<Timbrados> getAlls();   	//usa al repositorio 

	Optional<Timbrados> getById(Long id);		//Busca una ciudad por su ID.  Devuelve un Optional porque puede o no existir.

	void save(Timbrados timbrado);				//recibe un objeto completo de tipo Ciudades**El save() toma todo el objeto y lo guarda en la base de datos con repository.save(ciudad)

	void delete(Long id);		//Elimina una ciudad por su ID.
}
