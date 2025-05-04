package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "barrios")
@Data
public class Barrios {

    @Id								//	Indica que este campo es la clave primaria (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)		//Se genera automáticamente (por ejemplo, autoincremental)
    @Column(name = "id_barrio")			//Este campo en Java (id) corresponde a la columna id_ciudad en la BD
    private Long id;                  //  representa id_ciudad de la tabla 

  @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudades ciudad;       

    @Column(name = "descripcion", nullable = false, unique = true, length = 80)
    @Size(max = 80)
    private String descripcion;			//  representa descripcion de la tabla

}