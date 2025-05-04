package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.PedidoVentasDetalle;
import com.example.demo.models.PedidoVentasDetalleId;
import com.example.demo.repositories.PedidoVentasDetalleRepository;
import com.example.demo.services.PedidoVentasDetalleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoVentasDetalleServiceImpl implements PedidoVentasDetalleService {

    private final PedidoVentasDetalleRepository repository;

    @Override
    public List<PedidoVentasDetalle> getByPedidoId(Long idPedido) {
        return repository.findByIdPedidoVenta(idPedido);
    }

    @Override
    public void save(PedidoVentasDetalle detalle) {
        this.repository.save(detalle);
    }

    @Override
    public void deleteByPedidoId(Long idPedido) {
        repository.deleteByPedidoVentaId(idPedido);
    }

    @Override
    public void deleteItem(Long idPedido, Long idMercaderia) {
        // Implementar la eliminación de un ítem puntual si lo necesitas
    }

    @Override
    public Optional<PedidoVentasDetalle> getById(Long idPedido, Long idMercaderia) {
        // Usamos la clave compuesta para buscar el detalle de pedido
        PedidoVentasDetalleId id = new PedidoVentasDetalleId(idPedido, idMercaderia);
        return repository.findById(id); // findById buscará por la clave compuesta
    }

}
