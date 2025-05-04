package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TipodeImpuesto;

@Repository
public interface TipodeImpuestoRepository extends CrudRepository<TipodeImpuesto, Long> {

    @Query("SELECT d FROM TipodeImpuesto d")
    List<TipodeImpuesto> findByAll();
}
