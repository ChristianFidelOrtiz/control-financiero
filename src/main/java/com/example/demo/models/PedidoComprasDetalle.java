package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_compras_detalle")
@Data
public class PedidoComprasDetalle {

    @EmbeddedId
    private PedidoComprasDetalleId id;

    @ManyToOne
    @JoinColumn(name = "id_pedido_compra", insertable = false, updatable = false)
    private PedidoCompras pedidoCompra;

    // Si estás usando Mercaderia como entidad:
    // @ManyToOne
    // @JoinColumn(name = "id_mercaderia", insertable = false, updatable = false)
    // private Mercaderia mercaderia;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_compra")
    private int precioCompra;
}