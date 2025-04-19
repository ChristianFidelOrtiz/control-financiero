package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Ciudades;
import com.example.demo.services.CiudadesService;
import com.example.demo.services.DepartamentosService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Ciudades" })
@AllArgsConstructor
public class CiudadesController {

    private final CiudadesService service;
    private final DepartamentosService departamentosService;  

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Ciudades", service.getAlls());
        return "Ciudades/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ciudades", new Ciudades());
        model.addAttribute("departamentos", departamentosService.getAlls()); 
        return "ciudades/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ciudades ciudad) {
        service.save(ciudad);
        return "redirect:/Ciudades";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Ciudades> ciudad = service.getById(id);

        if (ciudad.isPresent()) {
            model.addAttribute("Ciudades", ciudad.get());
            return "Ciudades/formulario";
        }

        return "redirect:/Ciudades";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Ciudades";
    }
}

