package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.PedidoVentasDetalle;
import com.example.demo.models.PedidoVentasDetalleId;

@Repository
public interface PedidoVentasDetalleRepository extends CrudRepository<PedidoVentasDetalle, PedidoVentasDetalleId> {

  
    @Query("SELECT d FROM PedidoVentasDetalle d WHERE d.pedidoVentas.idPedidoVenta = :idPedido")
    List<PedidoVentasDetalle> findByIdPedidoVenta(Long idPedido);

    @Modifying
    @Transactional
    @Query("DELETE FROM PedidoVentasDetalle d WHERE d.pedidoVentas.idPedidoVenta = :idPedido")
    void deleteByPedidoVentaId(Long idPedido);

    
    // @Modifying
    // @Transactional
    // @Query("DELETE FROM PedidoVentasDetalle d WHERE d.pedidoVentas.idPedidoVenta = :idPedido AND d.mercaderia.idMercaderia = :idMercaderia")
    // void deleteById(Long idPedido, Long idMercaderia);
}
