package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PedidoVentas;
import com.example.demo.models.Timbrados;

@Repository
public interface PedidoVentasRepository extends CrudRepository<PedidoVentas, Long> {

    // Método para obtener todos los pedidos
    @Query("SELECT p FROM PedidoVentas p")
   List<PedidoVentas> findByAll();
    
    // Método para obtener un pedido por su ID
    @Query("SELECT p FROM PedidoVentas p WHERE p.idPedidoVenta = :id")
    Optional<PedidoVentas> findByIdPedido(Long id); // Devuelve un pedido por su ID

    // Puedes agregar más consultas personalizadas aquí si es necesario
}
