package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Bancos;



@Repository
public interface BancosRepository extends CrudRepository<Bancos, Long> {   //Ciudades → es la entidad en MOdels----Long → es el tipo de dato de la clave primaria (ID) de esa entidad en Models

	@Query("SELECT s from Bancos  s")    //Ciudades es la calce del modelo
	List<Bancos> findByAll();  			// Ciudades acá hace referencia a la clase del modelo (@Entity)                   consulta la tabla ciudades en la base de datos a traves de Modelo (@Entity)
}