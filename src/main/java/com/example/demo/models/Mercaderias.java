package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mercaderias")
@Data
public class Mercaderias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercaderia")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marcas marca;

    @ManyToOne
    @JoinColumn(name = "id_tipo_impuesto", nullable = false)
    private TipodeImpuesto tipoImpuesto;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "afecta_existencia", length = 1, nullable = false)
    private String afectaExistencia;

    @Column(name = "precio_compra", nullable = false)
    private Double precioCompra;

    @Column(name = "precio_venta", nullable = false)
    private Double precioVenta;

    
    //@ManyToOne
   // @JoinColumn(name = "id_procedencia", nullable = true)
   // private Procedencia procedencia;

}
