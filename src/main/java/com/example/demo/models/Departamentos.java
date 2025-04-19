package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "departamentos")
@Data
public class Departamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Paises pais; // Relación con la tabla paises

    @Column(name = "descripcion", nullable = false, unique = true, length = 80)
    @Size(max = 80)
    private String descripcion;
}
