package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.PedidoCompras;
import com.example.demo.services.PedidoComprasService;
import com.example.demo.services.ProveedoresService;
import com.example.demo.services.EmpleadosService;
import com.example.demo.services.SucursalesService;
import com.example.demo.services.CondicionService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/PedidoCompra")
@AllArgsConstructor
public class PedidoComprasController {

    private final PedidoComprasService service;
    private final ProveedoresService proveedoresService;
    private final EmpleadosService empleadosService;
    private final SucursalesService sucursalesService;
    private final CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vistaListaPedidos", service.getAlls());
        return "pedidoCompras/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("formPedido", new PedidoCompras());
        model.addAttribute("listaProveedores", proveedoresService.getAlls());
        model.addAttribute("listaEmpleados", empleadosService.getAlls());
        model.addAttribute("listaSucursales", sucursalesService.getAlls());
        model.addAttribute("listaCondiciones", condicionService.getAlls());
        return "pedidoCompras/formulario"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoCompras pedido) {
        service.save(pedido);
        return "redirect:/PedidoCompra";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<PedidoCompras> pedido = service.getById(id);

        if (pedido.isPresent()) {
            model.addAttribute("formPedido", pedido.get());
            model.addAttribute("listaProveedores", proveedoresService.getAlls());
            model.addAttribute("listaEmpleados", empleadosService.getAlls());
            model.addAttribute("listaSucursales", sucursalesService.getAlls());
            model.addAttribute("listaCondiciones", condicionService.getAlls());
            return "pedidoCompras/formulario";
        }

        return "redirect:/PedidoCompra";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/PedidoCompra";
    }
}
