package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.PedidoCompras;
import com.example.demo.models.PedidoComprasDetalle;
import com.example.demo.services.PedidoComprasDetalleService;
import com.example.demo.services.PedidoComprasService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/PedidoCompraDetalle")
@AllArgsConstructor
public class PedidoComprasDetalleController {

    private final PedidoComprasDetalleService detalleService;
    private final PedidoComprasService pedidoService;

    @GetMapping("/listar/{idPedido}")
    public String listar(@PathVariable Long idPedido, Model model) {
        model.addAttribute("detalles", detalleService.getByPedidoId(idPedido));
        model.addAttribute("idPedido", idPedido);
        return "pedidoComprasDetalle/listar";
    }

    @GetMapping("/form/{idPedido}")
    public String mostrarFormulario(@PathVariable Long idPedido, Model model) {
        PedidoComprasDetalle detalle = new PedidoComprasDetalle();
        PedidoCompras pedido = pedidoService.getById(idPedido).orElse(null);

        detalle.setPedidoCompra(pedido);

        model.addAttribute("formDetalle", detalle);
        model.addAttribute("idPedido", idPedido);
        // model.addAttribute("listaMercaderias", mercaderiasService.getAlls()); // Descomenta si lo usás
        return "pedidoComprasDetalle/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoComprasDetalle detalle) {
        detalleService.save(detalle);
        return "redirect:/PedidoCompraDetalle/listar/" + detalle.getPedidoCompra().getIdPedidoCompra();
    }
}
