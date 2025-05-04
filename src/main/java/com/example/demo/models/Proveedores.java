package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedores {

    @Id								
    @GeneratedValue(strategy = GenerationType.IDENTITY)		
    @Column(name = "id_proveedor")			
    private Long id;                 
   
    @ManyToOne
    @JoinColumn(name = "id_barrio", nullable = false)
    private Barrios barrios;


    @Column(name = "razon_social", nullable = false)
    private String razon;       
  
  @ Column(name = "ruc", nullable = false)
   private String ruc;       

   @Column(name = "direccion", nullable = false)
   private String direccion; 
  
   @Column(name = "telefono", nullable = false)
   private String telefono ; 
   
   @Column(name = "email", nullable = false)
   private String email; 
   
   @Column(name = "tipo_persona", nullable = false)
   private String tipo; 
   

}