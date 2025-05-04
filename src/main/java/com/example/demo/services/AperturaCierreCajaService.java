package com.example.demo.services;

import com.example.demo.models.AperturaCierreCaja;

import java.util.List;
import java.util.Optional;

public interface AperturaCierreCajaService {

    List<AperturaCierreCaja> getAlls();  // Devuelve todas las aperturas/cierres

    Optional<AperturaCierreCaja> getById(Integer id);  // Devuelve una apertura/cierre por ID

    void save(AperturaCierreCaja apertura);  // Guarda o actualiza un registro

    void delete(Integer id);  // Elimina un registro por ID
}
