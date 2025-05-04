
package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cajas;



@Repository
public interface CajasRepository extends CrudRepository<Cajas, Long> {   //Ciudades → es la entidad en MOdels----Long → es el tipo de dato de la clave primaria (ID) de esa entidad en Models

	@Query("SELECT s from Cajas  s")    //Ciudades es la calce del modelo
	List<Cajas> findByAll();  			// Ciudades acá hace referencia a la clase del modelo (@Entity)                   consulta la tabla ciudades en la base de datos a traves de Modelo (@Entity)
}



