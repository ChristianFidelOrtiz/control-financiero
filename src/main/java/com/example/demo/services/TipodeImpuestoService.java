package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TipodeImpuesto;

public interface TipodeImpuestoService {

    List<TipodeImpuesto> getAlls();

    Optional<TipodeImpuesto> getById(Long id);

    void save(TipodeImpuesto tdi);    // tdi: variable temporal

    void delete(Long id);
}