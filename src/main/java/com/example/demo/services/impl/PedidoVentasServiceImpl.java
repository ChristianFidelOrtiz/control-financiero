package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.PedidoVentas;
import com.example.demo.repositories.PedidoVentasRepository;
import com.example.demo.services.PedidoVentasService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoVentasServiceImpl implements PedidoVentasService {

    private final PedidoVentasRepository repository;

    @Override
    public List<PedidoVentas> getAlls() {
        return repository.findByAll();
    }

    @Override
    public Optional<PedidoVentas> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(PedidoVentas pedido) {
        this.repository.save(pedido);
    }

    @Override
    public void delete(Long id) {
        if (Objects.nonNull(id)) {
            this.repository.findById(id).ifPresent(pedido -> this.repository.delete(pedido));
        }
    }
}
