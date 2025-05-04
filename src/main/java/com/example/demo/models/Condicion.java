package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "condicion")
@Data
public class Condicion {

    @Id							
   // @GeneratedValue(strategy = GenerationType.IDENTITY)		//Se genera automáticamente (por ejemplo, autoincremental)
    @Column(name = "id_condicion")			//Este campo en Java (id) corresponde a la columna id_ciudad en la BD
    private Long id;                  //  representa id_ciudad de la tabla 

 // @ManyToOne
  //  @JoinColumn(name = "id_ciudad", nullable = false)
  //  private Ciudades ciudad;       

    @Column(name = "descripcion", nullable = false, unique = true, length = 80)
    @Size(max = 80)
    private String descripcion;			//  representa descripcion de la tabla

    @Column(name = "cuota", nullable = false, unique = true)
    private int cuota;	//  representa descripcion de la tabla
}