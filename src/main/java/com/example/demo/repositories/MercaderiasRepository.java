package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Mercaderias;

@Repository
public interface MercaderiasRepository extends CrudRepository<Mercaderias, Long> {   //Mercaderias → es la entidad en Models ---- Long → es el tipo de dato de la clave primaria (ID) de esa entidad en Models

    @Query("SELECT m FROM Mercaderias m")    //Mercaderias es la clase del modelo
    List<Mercaderias> findByAll();           // consulta la tabla mercaderias en la base de datos a través del modelo (@Entity)
}
