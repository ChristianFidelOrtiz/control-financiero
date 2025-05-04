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

import com.example.demo.models.Nacionalidades;
import com.example.demo.services.NacionalidadesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Nacionalidades" }) // la URL base para todas las rutas de esta clase
@AllArgsConstructor
public class NacionalidadesController {

    private final NacionalidadesService service;

    // Listar todas las Cajas
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("VistaListar", service.getAlls()); // pasa la lista de cajas al modelo
        return "nacionalidades/listar"; // nombre de la vista HTML
    }

    // Mostrar el formulario para crear una nueva Caja
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("FormVistar", new Nacionalidades()); // crea un nuevo objeto Cajas vacío
        return "nacionalidades/formulario"; // nombre de la vista HTML para el formulario
    }

    // Guardar una Caja (cuando se envía el formulario)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Nacionalidades nacionalidad) {  // recibe el objeto Cajas desde el formulario
        service.save(nacionalidad); // guarda la caja en la base de datos
        return "redirect:/Nacionalidades";  // redirige de vuelta a la lista de Cajas
    }

    // Editar una Caja
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Nacionalidades> nacionalidad = service.getById(id); // busca la caja por id

        if (nacionalidad.isPresent()) {
            model.addAttribute("FormVistar", nacionalidad.get()); // pasa la caja encontrada al formulario
            return "nacionalidades/formulario"; // abre el formulario con los datos de la caja
        }

        return "redirect:/Nacionalidades"; // redirige a la lista si no se encuentra la caja
    }

    // Eliminar una Caja
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id); // elimina la caja con el id proporcionado
        return "redirect:/Nacionalidades"; // redirige a la lista de Cajas
    }
}