package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import com.example.demo.models.PedidoVentasDetalle;

public interface PedidoVentasDetalleService {

    List<PedidoVentasDetalle> getByPedidoId(Long idPedido); // Detalles por cabecera

    Optional<PedidoVentasDetalle> getById(Long idPedido, Long idMercaderia);  // Devuelve un pedido por su ID

    void save(PedidoVentasDetalle detalle); // Guardar un ítem de detalle

    void deleteByPedidoId(Long idPedido); // Borrar todos los detalles de un pedido (opcional según tu lógica)

    void deleteItem(Long idPedido, Long idMercaderia); // Eliminar un ítem puntual del detalle (clave compuesta)
}
