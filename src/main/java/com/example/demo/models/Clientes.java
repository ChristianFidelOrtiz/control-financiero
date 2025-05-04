package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Clientes {

    @Id								//	Indica que este campo es la clave primaria (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)		//Se genera automáticamente (por ejemplo, autoincremental)
    @Column(name = "id_cliente")			//Este campo en Java (id) corresponde a la columna id_ciudad en la BD
    private Long id;                  //  representa id_ciudad de la tabla 

  @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrios Barrio;         

    @Column(name = "razon_social", nullable = false, length = 80)
    @Size(max = 80)
    private String razonSocial;	
    
    @Column(name = "ruc", nullable = false, length = 80)
    @Size(max = 80)
    private String ruc;			//  representa descripcion de la tabla

    @Column(name = "direccion", nullable = false, length = 80)
    @Size(max = 80)
    private String direccion;			//  representa descripcion de la tabla
    
    @Column(name = "telefono", nullable = false, length = 80)
    @Size(max = 80)
    private String telefono;			//  representa descripcion de la tabla

    @Column(name = "email", nullable = false, length = 80)
    @Size(max = 80)
    private String email;			//  representa descripcion de la tabla
    
    @Column(name = "tipo_cliente", nullable = false, length = 80)
    @Size(max = 80)
    private String tipoCliente;			//  representa descripcion de la tabla
}