package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.AperturaCierreCaja;
import com.example.demo.repositories.AperturaCierreCajaRepository;
import com.example.demo.services.AperturaCierreCajaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AperturaCierreCajaServiceImpl implements AperturaCierreCajaService {

    private final AperturaCierreCajaRepository repository;

    @Override
    public List<AperturaCierreCaja> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<AperturaCierreCaja> getById(Integer id) {
        return repository.findByIdApertura(id);
    }

    @Override
    public void save(AperturaCierreCaja apertura) {
        this.repository.save(apertura);
    }

    @Override
    public void delete(Integer id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(reg -> this.repository.delete(reg));
        }
    }
}
