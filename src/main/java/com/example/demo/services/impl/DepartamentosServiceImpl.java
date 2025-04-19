package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Departamentos;
import com.example.demo.repositories.DepartamentosRepository;
import com.example.demo.services.DepartamentosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartamentosServiceImpl implements DepartamentosService {

    private final DepartamentosRepository departamentosRepository;

    @Override
    public List<Departamentos> getAlls() {
        return departamentosRepository.findByAll();  
    }

    @Override
    public Optional<Departamentos> getById(Long id) {
        return departamentosRepository.findById(id);  
    }

    @Override
    public void save(Departamentos departamento) {
        departamentosRepository.save(departamento);  
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            departamentosRepository.findById(id)
                .ifPresent(departamento -> departamentosRepository.delete(departamento));  
        }
    }
}
