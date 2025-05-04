package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "bancos")
@Data
public class Bancos {

    @Id							
   // @GeneratedValue(strategy = GenerationType.IDENTITY)		//Se genera automáticamente (por ejemplo, autoincremental)
    @Column(name = "id_banco")			//Este campo en Java (id) corresponde a la columna id_ciudad en la BD
    private Long id;                  //  representa id_ciudad de la tabla       

    @Column(name = "descripcion", nullable = false, unique = true, length = 80)
    @Size(max = 80)
    private String descripcion;			//  representa descripcion de la tabla

    @Column(name = "telefono", nullable = false, unique = true)
    private int telefono;	//  representa descripcion de la tabla
    
    @Column(name = "direccion", nullable = false, unique = true, length = 80)
    @Size(max = 80)
    private String direccion;			//  representa descripcion de la tabla
}