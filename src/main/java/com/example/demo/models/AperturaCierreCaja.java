package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "apertura_cierre_caja")
@Data
public class AperturaCierreCaja {

    @Id
    @Column(name = "id_apertura_cierre")
    private Integer idAperturaCierre;

    @ManyToOne
    @JoinColumn(name = "id_caja", nullable = false)
    private Cajas caja;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_apertura")
    private LocalDate fechaApertura;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_apertura")
    private LocalTime horaApertura;

    @Column(name = "monto_apertura")
    private Integer montoApertura;

    @ManyToOne
    @JoinColumn(name = "id_usuario_apertura", nullable = false)
    private Usuarios usuarioApertura;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_cierre")
    private LocalTime horaCierre;

    @Column(name = "monto_cierre")
    private Integer montoCierre;

    @Column(name = "estado", length = 3)
    private String estado;

    @Column(name = "monto_efectivo", precision = 12, scale = 2)
    private BigDecimal montoEfectivo;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_usuario_cierre")
    private Usuarios usuarioCierre;
}
