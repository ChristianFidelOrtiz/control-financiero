package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.TipodeImpuesto;
import com.example.demo.services.TipodeImpuestoService;


import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/TipodeImpuesto")
@AllArgsConstructor
public class TipodeImpuestoController {

    private final TipodeImpuestoService tipodeimpuestoService;
    

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("impuestos", tipodeimpuestoService.getAlls());
        return "tipo de impuesto/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("enlace2", new TipodeImpuesto());
        return "tipo de impuesto/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute TipodeImpuesto tdi) {
        tipodeimpuestoService.save(tdi);
        return "redirect:/TipodeImpuesto";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<TipodeImpuesto> tdi2 = tipodeimpuestoService.getById(id);

        if (tdi2.isPresent()) {
            model.addAttribute("enlace2", tdi2.get());
            return "tipo de impuesto/formulario";
        }

        return "redirect:/TipodeImpuesto";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        tipodeimpuestoService.delete(id);
        return "redirect:/TipodeImpuesto";
    }
}