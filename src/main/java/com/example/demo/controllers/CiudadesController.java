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
        model.addAttribute("Ciudades", service.getAlls()); //Model es un contenedor que pasamos entre el controlador y la vista. //  "Ciudades" es una variable temp que toma los datos y los pasa al html   // getAlls() leee de la base de datos y agrega a la variable tem ara la lectuta en el html // El nombre que usás en el HTML (${algo}) debe coincidir exactamente con el que pusiste en addAttribute("algo", ...)
        return "Ciudades/listar";   // al terminar Spring redirige al navegador a Ciudades/listar // escribir cómo están nombradas tus carpetas y archivos en el sistema de archivos.
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ciudades", new Ciudades()); 		// crea un objeto nuevo Ciudades con los atributos ingresados en html
        model.addAttribute("departamentos", departamentosService.getAlls()); 
        return "Ciudades/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ciudades ciudad) {  // recibe los datos del html objeto (Clase-- variable tem html)
        service.save(ciudad);		// envia a service 
        return "redirect:/Ciudades";  //al terminar Spring redirige al navegador a /Ciudades 
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Ciudades> ciudad = service.getById(id); // varible local ciudad toma los datos de get id; 

        if (ciudad.isPresent()) { 			// busca la id
            model.addAttribute("Ciudades", ciudad.get());	// si encuentra Obtiene el valor (si existe)
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

