package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PedidoVentas;

public interface PedidoVentasService {

    List<PedidoVentas> getAlls(); 

    Optional<PedidoVentas> getById(Long id); 

    void save(PedidoVentas pedido); 

    void delete(Long id);  
}
