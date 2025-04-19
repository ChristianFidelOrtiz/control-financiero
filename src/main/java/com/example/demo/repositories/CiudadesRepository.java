
package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Ciudades;



@Repository
public interface CiudadesRepository extends CrudRepository<Ciudades, Long> {

	@Query("SELECT s from Ciudades s")
	List<Ciudades> findByAll();
}