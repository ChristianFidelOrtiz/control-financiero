package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Empleados;

@Repository
public interface EmpleadosRepository extends CrudRepository<Empleados, Long> {

    @Query("SELECT d FROM Empleados d")
    List<Empleados> findByAll();
}
