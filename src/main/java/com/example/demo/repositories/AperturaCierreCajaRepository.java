package com.example.demo.repositories;

import com.example.demo.models.AperturaCierreCaja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AperturaCierreCajaRepository extends CrudRepository<AperturaCierreCaja, Integer> {

    // Obtener todas las aperturas/cierres de caja
    @Query("SELECT a FROM AperturaCierreCaja a")
    List<AperturaCierreCaja> findByAll();

    // Obtener un registro por su ID
    @Query("SELECT a FROM AperturaCierreCaja a WHERE a.idAperturaCierre = :id")
    Optional<AperturaCierreCaja> findByIdApertura(Integer id);
}
