package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PedidoCompras;

@Repository
public interface PedidoComprasRepository extends CrudRepository<PedidoCompras, Long> {

   
    @Query("SELECT p FROM PedidoCompras p")
    List<PedidoCompras> findByAll();

    
    @Query("SELECT p FROM PedidoCompras p WHERE p.idPedidoCompra = :id")
    Optional<PedidoCompras> findByIdPedido(Long id);
}
