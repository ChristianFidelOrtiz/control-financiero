package com.example.demo.services;

import com.example.demo.models.PedidoComprasDetalle;

import java.util.List;
import java.util.Optional;

public interface PedidoComprasDetalleService {

    
    List<PedidoComprasDetalle> getByPedidoId(Long idPedido);

    
    Optional<PedidoComprasDetalle> getById(Long idPedido, Long idMercaderia);

    
    void save(PedidoComprasDetalle detalle);

    void deleteByPedidoId(Long idPedido);

   
    void deleteItem(Long idPedido, Long idMercaderia);
}

