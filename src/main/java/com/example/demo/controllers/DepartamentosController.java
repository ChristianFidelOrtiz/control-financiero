package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Departamentos;
import com.example.demo.services.DepartamentosService;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Departamentos")
@AllArgsConstructor
public class DepartamentosController {

    private final DepartamentosService departamentosService;
    private final PaisesService paisesService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Departamentos", departamentosService.getAlls());
        return "departamentos/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("departamentos", new Departamentos());
        model.addAttribute("listaPaises", paisesService.getAlls());
        return "departamentos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Departamentos departamento) {
        departamentosService.save(departamento);
        return "redirect:/Departamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Departamentos> departamento = departamentosService.getById(id);

        if (departamento.isPresent()) {
            model.addAttribute("departamentos", departamento.get());
            model.addAttribute("listaPaises", paisesService.getAlls());
            return "departamentos/formulario";
        }

        return "redirect:/Departamentos";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        departamentosService.delete(id);
        return "redirect:/Departamentos";
    }
}
