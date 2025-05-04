package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "estado_civil")
@Data
public class EstadoCivil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_civil")
    private Long id;

    @Column(name = "descripcion", nullable = true, unique = false, length = 50)
    @Size(max = 50)
    private String descripcion;
}