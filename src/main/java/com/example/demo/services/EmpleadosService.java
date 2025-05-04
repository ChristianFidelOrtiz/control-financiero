package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Empleados;

public interface EmpleadosService {

    List<Empleados> getAlls();

    Optional<Empleados> getById(Long id);

    void save(Empleados empleado);

    void delete(Long id);
}