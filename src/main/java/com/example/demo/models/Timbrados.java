package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "timbrados")
@Data
public class Timbrados {

    @Id
    @Column(name = "id_timbrado") // no se genera automáticamente
    private Long id;

    @Column(name = "nro_desde", nullable = false)
    private int nroDesde;

    @Column(name = "nro_hasta", nullable = false)
    private int nroHasta;

    @Column(name = "nro3", nullable = false)
    private int nro3;

    @Column(name = "nro_timbrado", nullable = false)
    private int nroTimbrado;

  
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "estado", length = 3)
    @Size(max = 3)
    private String estado;

   @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    private TipoDeDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "nro1", referencedColumnName = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "nro2", referencedColumnName = "id_caja")
    private Cajas caja;
}