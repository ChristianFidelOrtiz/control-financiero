package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "ciudades")
@Data
public class Ciudades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long id;

  @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private Departamentos departamento; 

    @Column(name = "descripcion", nullable = false, unique = true, length = 80)
    @Size(max = 80)
    private String descripcion;

}