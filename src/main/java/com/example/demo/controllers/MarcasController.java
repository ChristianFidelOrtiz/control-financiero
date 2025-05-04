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

import com.example.demo.models.Marcas;
import com.example.demo.services.MarcasService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Marcas" })
@AllArgsConstructor
public class MarcasController {

    private final MarcasService service;  

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("Marcas", service.getAlls()); //Model es un contenedor que pasamos entre el controlador y la vista. //  "Ciudades" es una variable temp que toma los datos y los pasa al html   // getAlls() leee de la base de datos y agrega a la variable tem ara la lectuta en el html // El nombre que usás en el HTML (${algo}) debe coincidir exactamente con el que pusiste en addAttribute("algo", ...)
        return "marcas/listar";   // al terminar Spring redirige al navegador a Ciudades/listar // escribir cómo están nombradas tus carpetas y archivos en el sistema de archivos.
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("marcas", new Marcas()); 		// crea un objeto nuevo Ciudades con los atributos ingresados en html
        return "marcas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Marcas marca) {  // recibe los datos del html objeto (Clase-- variable tem html)
        service.save(marca);		// envia a service 
        return "redirect:/Marcas";  //al terminar Spring redirige al navegador a /Ciudades 
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Marcas> marca = service.getById(id); // varible local ciudad toma los datos de get id; 

        if (marca.isPresent()) { 			// busca la id
            model.addAttribute("marcas", marca.get());	// si encuentra Obtiene el valor (si existe)
            return "marcas/formulario";
        }

        return "redirect:/Marcas";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Marcas";
    }
}
