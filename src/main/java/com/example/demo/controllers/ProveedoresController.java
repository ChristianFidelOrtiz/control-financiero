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

import com.example.demo.models.Proveedores;
import com.example.demo.services.ProveedoresService;
import com.example.demo.services.BarriosService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Proveedores" })
@AllArgsConstructor
public class ProveedoresController {

    private final ProveedoresService service;
    private final BarriosService barriosService;  

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("enlace1", service.getAlls()); //Model es un contenedor que pasamos entre el controlador y la vista. //  "Ciudades" es una variable temp que toma los datos y los pasa al html   // getAlls() leee de la base de datos y agrega a la variable tem ara la lectuta en el html // El nombre que usás en el HTML (${algo}) debe coincidir exactamente con el que pusiste en addAttribute("algo", ...)
        return "proveedores/listar";   // al terminar Spring redirige al navegador a Ciudades/listar // escribir cómo están nombradas tus carpetas y archivos en el sistema de archivos.
    }

    @GetMapping("/form")
    public String mostrarProveedor(Model model) {
        model.addAttribute("enlace2", new Proveedores()); 		// crea un objeto nuevo Ciudades con los atributos ingresados en html
        model.addAttribute("barrios", barriosService.getAlls()); 
        return "proveedores/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedores proveedor) {  // recibe los datos del html objeto (Clase-- variable tem html)
        service.save(proveedor);		// envia a service 
        return "redirect:/Proveedores";  //al terminar Spring redirige al navegador a /Ciudades 
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Proveedores> proveedores2 = service.getById(id); // varible local ciudad toma los datos de get id; 

        if (proveedores2.isPresent()) { 			// busca la id
            model.addAttribute("enlace2", proveedores2.get());
            model.addAttribute("barrios", barriosService.getAlls());
            return "proveedores/formulario";
        }

        return "redirect:/Proveedores";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Proveedores";
    }
}