package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Departamentos;

public interface DepartamentosService {

    List<Departamentos> getAlls();

    Optional<Departamentos> getById(Long id);

    void save(Departamentos departamento);

    void delete(Long id);
}