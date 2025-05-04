package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_ventas_detalle")
@Data
public class PedidoVentasDetalle {

    @EmbeddedId
    private PedidoVentasDetalleId id; // Clave primaria compuesta

    @ManyToOne
    @JoinColumn(name = "id_pedido_venta", insertable = false, updatable = false)
    private PedidoVentas pedidoVentas; // Relación con la entidad PedidoVentas

   // @ManyToOne
   // @JoinColumn(name = "id_mercaderia", insertable = false, updatable = false)
  //  private Mercaderia mercaderia; // Relación con la entidad Mercaderia

    @Column(name = "cantidad", nullable = false)
    private int cantidad; // Cantidad de productos

    @Column(name = "precio_venta", nullable = false)
    private int precioVenta; // Precio de venta del producto
}
