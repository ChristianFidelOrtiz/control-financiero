package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PedidoVentasDetalleId implements Serializable {

    @Column(name = "id_pedido_venta")
    private Long idPedidoVenta;

    @Column(name = "id_mercaderia")
    private Long idMercaderia;

   
    public PedidoVentasDetalleId() {}


    public PedidoVentasDetalleId(Long idPedidoVenta, Long idMercaderia) {
        this.idPedidoVenta = idPedidoVenta;
        this.idMercaderia = idMercaderia;
    }

  
    public Long getIdPedidoVenta() {
        return idPedidoVenta;
    }

    public void setIdPedidoVenta(Long idPedidoVenta) {
        this.idPedidoVenta = idPedidoVenta;
    }

   // public Long getIdMercaderia() {
   //     return idMercaderia;
   // }

   // public void setIdMercaderia(Long idMercaderia) {
   //     this.idMercaderia = idMercaderia;
   // }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoVentasDetalleId)) return false;
        PedidoVentasDetalleId that = (PedidoVentasDetalleId) o;
        return Objects.equals(idPedidoVenta, that.idPedidoVenta) &&
               Objects.equals(idMercaderia, that.idMercaderia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedidoVenta, idMercaderia);
    }
}
