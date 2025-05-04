package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Mercaderias;
import com.example.demo.services.MercaderiasService;
import com.example.demo.services.ProveedoresService;
import com.example.demo.services.MarcasService;
import com.example.demo.services.TipodeImpuestoService;
import com.example.demo.services.BarriosService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Mercaderias" })
@AllArgsConstructor
public class MercaderiasController {

    private final MercaderiasService service;
    private final ProveedoresService proveedoresService;
    private final MarcasService marcasService;
    private final TipodeImpuestoService tipoImpuestoService;
    private final BarriosService barrioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Mercaderias", service.getAlls());
        return "mercaderias/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("Mercaderias", new Mercaderias());
        model.addAttribute("proveedores", proveedoresService.getAlls());
        model.addAttribute("marca", marcasService.getAlls());
        model.addAttribute("tipoImpuesto", tipoImpuestoService.getAlls());
        model.addAttribute("barrio", barrioService.getAlls());

        // Debug: mostrar tamaños de las listas
        System.out.println("Marcas: " + marcasService.getAlls().size());
        System.out.println("Tipo de Impuesto: " + tipoImpuestoService.getAlls().size());
        System.out.println("Barrios: " + barrioService.getAlls().size());
        System.out.println("Proveedores: " + proveedoresService.getAlls().size());

        return "mercaderias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Mercaderias mercaderia) {
        service.save(mercaderia);
        return "redirect:/Mercaderias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Mercaderias> mercaderia2 = service.getById(id);

        if (mercaderia2.isPresent()) {
            model.addAttribute("Mercaderias", mercaderia2.get());
            model.addAttribute("proveedores", proveedoresService.getAlls());
            model.addAttribute("marca", marcasService.getAlls());
            model.addAttribute("tipoImpuesto", tipoImpuestoService.getAlls());
            model.addAttribute("barrio", barrioService.getAlls());

            // Debug
            System.out.println("Marcas: " + marcasService.getAlls().size());
            System.out.println("Tipo de Impuesto: " + tipoImpuestoService.getAlls().size());
            System.out.println("Barrios: " + barrioService.getAlls().size());
            System.out.println("Proveedores: " + proveedoresService.getAlls().size());

            return "mercaderias/formulario";
        }

        return "redirect:/Mercaderias";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Mercaderias";
    }
}
