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

import com.example.demo.models.Clientes;
import com.example.demo.services.BarriosService;
import com.example.demo.services.ClientesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Clientes" }) 			// utilizan todos los href y los redirect
@AllArgsConstructor
public class ClientesController {

    private final ClientesService service;
    private final BarriosService barriosService; 
  

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("VistaListar", service.getAlls()); //Model es un contenedor que pasamos entre el controlador y la vista. //  "Ciudades" es una variable temp que toma los datos y los pasa al html   // getAlls() leee de la base de datos y agrega a la variable tem ara la lectuta en el html // El nombre que usás en el HTML (${algo}) debe coincidir exactamente con el que pusiste en addAttribute("algo", ...)
        return "clientes/listar";   // al terminar Spring redirige al navegador a Ciudades/listar // escribir cómo están nombradas tus carpetas y archivos en el sistema de archivos.
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("FormVistar", new Clientes()); 		// crea un objeto nuevo Ciudades con los atributos ingresados en html
     model.addAttribute("selectVistar", barriosService.getAlls()); 
        return "clientes/formulario";    // direccion del archibo html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Clientes cliente) {  // recibe los datos del html objeto (Clase-- variable tem html)
        service.save(cliente);		// envia a service 
        return "redirect:/Clientes";  // tiene q estar escrito igual que (path = { "/Barrios" })
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Clientes> cliente = service.getById(id); // varible local ciudad toma los datos de get id; 

        if (cliente.isPresent()) { 			// busca la id
          
            model.addAttribute("FormVistar", cliente.get());		 	// usa el objeto formVistar de mostrarformulario
         model.addAttribute("selectVistar", barriosService.getAlls()); // Ciudades selectVistar es un enlace con el select del formulario
            return "clientes/formulario";
        }

        return "redirect:/Clientes";   //  tiene q estar escrito igual que (path = { "/Barrios" })
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Clientes";			//  tiene q estar escrito igual que (path = { "/Barrios" })
    }
}
