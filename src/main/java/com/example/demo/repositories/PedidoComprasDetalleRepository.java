package com.example.demo.repositories;

import com.example.demo.models.PedidoComprasDetalle;
import com.example.demo.models.PedidoComprasDetalleId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PedidoComprasDetalleRepository extends CrudRepository<PedidoComprasDetalle, PedidoComprasDetalleId> {

	
    @Query("SELECT d FROM PedidoComprasDetalle d WHERE d.pedidoCompra.idPedidoCompra = :idPedido")
    List<PedidoComprasDetalle> findByIdPedidoCompra(Long idPedido);

    @Modifying
    @Transactional
    @Query("DELETE FROM PedidoComprasDetalle d WHERE d.pedidoCompra.idPedidoCompra = :idPedido")
    void deleteByPedidoCompraId(Long idPedido);
}
