package com.example.demo.services.impl;

import com.example.demo.models.PedidoComprasDetalle;
import com.example.demo.models.PedidoComprasDetalleId;
import com.example.demo.repositories.PedidoComprasDetalleRepository;
import com.example.demo.services.PedidoComprasDetalleService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoComprasDetalleServiceImpl implements PedidoComprasDetalleService {

    private final PedidoComprasDetalleRepository repository;

    @Override
    public List<PedidoComprasDetalle> getByPedidoId(Long idPedido) {
        return repository.findByIdPedidoCompra(idPedido);
    }

    @Override
    public Optional<PedidoComprasDetalle> getById(Long idPedido, Long idMercaderia) {
        PedidoComprasDetalleId id = new PedidoComprasDetalleId(idPedido, idMercaderia);
        return repository.findById(id);
    }

    @Override
    public void save(PedidoComprasDetalle detalle) {
        repository.save(detalle);
    }

    @Override
    public void deleteByPedidoId(Long idPedido) {
        repository.deleteByPedidoCompraId(idPedido);
    }

    @Override
    public void deleteItem(Long idPedido, Long idMercaderia) {
        PedidoComprasDetalleId id = new PedidoComprasDetalleId(idPedido, idMercaderia);
        repository.deleteById(id);
    }
}
