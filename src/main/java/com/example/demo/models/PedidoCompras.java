package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido_compras")
@Data
public class PedidoCompras {

    @Id
    @Column(name = "id_pedido_compra")
    private Long idPedidoCompra;

    @Column(name = "observacion", length = 200, nullable = true)
    private String observacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado", length = 1, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_condicion", referencedColumnName = "id_condicion")
    private Condicion condicion;

    @OneToMany(mappedBy = "pedidoCompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoComprasDetalle> detalles;
}
