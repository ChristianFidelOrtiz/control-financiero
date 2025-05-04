package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.PedidoVentas;
import com.example.demo.models.PedidoVentasDetalle;
// import com.example.demo.services.MercaderiasService;
import com.example.demo.services.PedidoVentasDetalleService;
import com.example.demo.services.PedidoVentasService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/PedidoVentaDetalle")
@AllArgsConstructor
public class PedidoVentasDetalleController {

    private final PedidoVentasDetalleService detalleService;
    private final PedidoVentasService pedidoService;
   // private final MercaderiasService mercaderiasService;

    @GetMapping("/listar/{idPedido}")
    public String listar(@PathVariable Long idPedido, Model model) {
        model.addAttribute("detalles", detalleService.getByPedidoId(idPedido));
        model.addAttribute("idPedido", idPedido);
        return "pedidoVentasDetalles/listar";
    }

    @GetMapping("/form/{idPedido}")
    public String mostrarFormulario(@PathVariable Long idPedido, Model model) {
        PedidoVentasDetalle detalle = new PedidoVentasDetalle();
        PedidoVentas pedido = pedidoService.getById(idPedido).orElse(null); 

        detalle.setPedidoVentas(pedido);

        model.addAttribute("formDetalle", detalle);
        model.addAttribute("idPedido", idPedido);
   //     model.addAttribute("listaMercaderias", mercaderiasService.getAlls()); // Debes tener este método
        return "pedidoVentasDetalles/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoVentasDetalle detalle) {
        detalleService.save(detalle);
        return "redirect:/PedidoVentaDetalle/listar/" + detalle.getPedidoVentas().getIdPedidoVenta();
    }

    @GetMapping("/editar/{idPedido}/{idMercaderia}")
    public String editar(@PathVariable Long idPedido, @PathVariable Long idMercaderia, Model model) {
        Optional<PedidoVentasDetalle> detalleOpt = detalleService.getById(idPedido, idMercaderia);

        if (detalleOpt.isPresent()) {
            model.addAttribute("FormVistar", detalleOpt.get());
      //      model.addAttribute("listaMercaderias", mercaderiasService.getAlls());
            return "pedidoVentasDetalles/formulario";
        }

        return "redirect:/PedidoVentaDetalle/listar/" + idPedido;
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long idPedido, @RequestParam Long idMercaderia) {
        detalleService.deleteItem(idPedido, idMercaderia);
        return "redirect:/PedidoVentaDetalle/listar/" + idPedido;
    }
}

