package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "cajas")
@Data
public class Cajas {

    @Id
    @Column(name = "id_caja")
    private Long id;

    @Column(name = "descripcion", nullable = true, unique = false, length = 50)
    @Size(max = 50)
    private String descripcion;
}