package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PedidoCompras;

public interface PedidoComprasService {

    List<PedidoCompras> getAlls(); 

    Optional<PedidoCompras> getById(Long id); 

    void save(PedidoCompras pedido); 

    void delete(Long id);  
}
