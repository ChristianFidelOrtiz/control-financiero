package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Empleados;
import com.example.demo.services.EmpleadosService;
import com.example.demo.services.BarriosService;
import com.example.demo.services.UsuariosService;
import com.example.demo.services.NacionalidadesService;
import com.example.demo.services.EstadoCivilService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Empleados")
@AllArgsConstructor
public class EmpleadosController {

    private final EmpleadosService empleadosService;
    private final BarriosService barriosService;
    private final UsuariosService usuariosService;
    private final NacionalidadesService nacionalidadesService;
    private final EstadoCivilService estadoCivilService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaEmpleados", empleadosService.getAlls());
        return "empleados/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleados());
        model.addAttribute("listaBarrios", barriosService.getAlls());
        model.addAttribute("listaUsuarios", usuariosService.getAlls());
        model.addAttribute("listaNacionalidades", nacionalidadesService.getAlls());
        model.addAttribute("listaEstadosCiviles", estadoCivilService.getAlls());
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleados empleado) {
        empleadosService.save(empleado);
        return "redirect:/Empleados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Empleados> empleado = empleadosService.getById(id);

        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            model.addAttribute("listaBarrios", barriosService.getAlls());
            model.addAttribute("listaUsuarios", usuariosService.getAlls());
            model.addAttribute("listaNacionalidades", nacionalidadesService.getAlls());
           model.addAttribute("listaEstadosCiviles", estadoCivilService.getAlls());
            return "empleados/formulario";
        }

        return "redirect:/Empleados";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        empleadosService.delete(id);
        return "redirect:/Empleados";
    }
}
