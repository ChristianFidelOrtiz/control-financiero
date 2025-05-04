package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PedidoComprasDetalleId implements Serializable {

    @Column(name = "id_pedido_compra")
    private Long idPedidoCompra;

    @Column(name = "id_mercaderia")
    private Long idMercaderia;

    public PedidoComprasDetalleId() {}

    
    public PedidoComprasDetalleId(Long idPedidoCompra, Long idMercaderia) {
        this.idPedidoCompra = idPedidoCompra;
        this.idMercaderia = idMercaderia;
    }

    public Long getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(Long idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public Long getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(Long idMercaderia) {
        this.idMercaderia = idMercaderia;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoComprasDetalleId)) return false;
        PedidoComprasDetalleId that = (PedidoComprasDetalleId) o;
        return Objects.equals(idPedidoCompra, that.idPedidoCompra) &&
               Objects.equals(idMercaderia, that.idMercaderia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedidoCompra, idMercaderia);
    }
}
