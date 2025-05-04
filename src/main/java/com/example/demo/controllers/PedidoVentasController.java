package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.PedidoVentas;
import com.example.demo.services.PedidoVentasService;
import com.example.demo.services.ClientesService;
import com.example.demo.services.EmpleadosService;
import com.example.demo.services.SucursalesService;
import com.example.demo.services.CondicionService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/PedidoVenta")
@AllArgsConstructor
public class PedidoVentasController {

    private final PedidoVentasService service;
    private final ClientesService clientesService;
    private final EmpleadosService empleadosService;
    private final SucursalesService sucursalesService;
    private final CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vistaListaPedidos", service.getAlls());
        return "pedidoVentas/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("formPedido", new PedidoVentas());
        model.addAttribute("listaClientes", clientesService.getAlls());
        model.addAttribute("listaEmpleados", empleadosService.getAlls());
        model.addAttribute("listaSucursales", sucursalesService.getAlls());
        model.addAttribute("listaCondiciones", condicionService.getAlls());
        return "pedidoVentas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoVentas pedido) {
        service.save(pedido);
        return "redirect:/PedidoVenta";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<PedidoVentas> pedido = service.getById(id);

        if (pedido.isPresent()) {
            model.addAttribute("formPedido", pedido.get());
            model.addAttribute("listaClientes", clientesService.getAlls());
            model.addAttribute("listaEmpleados", empleadosService.getAlls());
            model.addAttribute("listaSucursales", sucursalesService.getAlls());
            model.addAttribute("listaCondiciones", condicionService.getAlls());
            return "pedidoVentas/formulario";
        }

        return "redirect:/PedidoVenta";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/PedidoVentas";
    }
}
