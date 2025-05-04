package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Mercaderias;
import com.example.demo.repositories.MercaderiasRepository;
import com.example.demo.services.MercaderiasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MercaderiasServiceImpl implements MercaderiasService {

    private final MercaderiasRepository repository;

    @Override
    public List<Mercaderias> getAlls() {

        return repository.findByAll();
    }

    @Override
    public Optional<Mercaderias> getById(Long id) {

        return repository.findById(id);
    }

    @Override
    public void save(Mercaderias mercaderia) {
        this.repository.save(mercaderia);
    }

    @Override
    public void delete(Long id) {

        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(mercaderia -> this.repository.delete(mercaderia));
        }
    }

}
