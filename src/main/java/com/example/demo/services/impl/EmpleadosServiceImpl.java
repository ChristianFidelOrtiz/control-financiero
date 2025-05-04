package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Empleados;
import com.example.demo.repositories.EmpleadosRepository;
import com.example.demo.services.EmpleadosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleados> getAlls() {
        return empleadosRepository.findByAll();  
    }

    @Override
    public Optional<Empleados> getById(Long id) {
        return empleadosRepository.findById(id);  
    }

    @Override
    public void save(Empleados empleado) {
    	empleadosRepository.save(empleado);  
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
        	empleadosRepository.findById(id)
                .ifPresent(empleado -> empleadosRepository.delete(empleado));  
        }
    }
}
