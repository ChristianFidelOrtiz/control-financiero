package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.TipodeImpuesto;
import com.example.demo.repositories.TipodeImpuestoRepository;
import com.example.demo.services.TipodeImpuestoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipodeImpuestoImpl implements TipodeImpuestoService {

    private final TipodeImpuestoRepository tipodeimpuestoRepository;

    @Override
    public List<TipodeImpuesto> getAlls() {
        return tipodeimpuestoRepository.findByAll();  
    }

    @Override
    public Optional<TipodeImpuesto> getById(Long id) {
        return  tipodeimpuestoRepository.findById(id);  
    }

    @Override
    public void save(TipodeImpuesto tdi) {
        tipodeimpuestoRepository.save(tdi);  
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            tipodeimpuestoRepository.findById(id)
                .ifPresent(tdi -> tipodeimpuestoRepository.delete(tdi));  
        }
    }
}
