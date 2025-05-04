package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Marcas;



@Repository
public interface MarcasRepository extends CrudRepository<Marcas, Long> {   //Ciudades → es la entidad en MOdels----Long → es el tipo de dato de la clave primaria (ID) de esa entidad en Models

	@Query("SELECT s from Marcas s")    //Ciudades es la calce del modelo
	List<Marcas> findByAll();  			// Ciudades acá hace referencia a la clase del modelo (@Entity)                   consulta la tabla ciudades en la base de datos a traves de Modelo (@Entity)
}