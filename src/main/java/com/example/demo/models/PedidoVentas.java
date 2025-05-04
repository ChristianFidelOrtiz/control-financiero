package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedido_ventas")
@Data
public class PedidoVentas {

    @Id
    @Column(name = "id_pedido_venta") 
    private Long idPedidoVenta;

    @Column(name = "observacion", nullable = true, length = 200)
    private String observacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado", length = 1, nullable = false)
    private String estado; 

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Clientes cliente; 

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleados empleado; 

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private Sucursales sucursal; 

    @ManyToOne
    @JoinColumn(name = "id_condicion", referencedColumnName = "id_condicion")
    private Condicion condicion; 
  
    @OneToMany(mappedBy = "pedidoVentas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoVentasDetalle> detalles;
}
