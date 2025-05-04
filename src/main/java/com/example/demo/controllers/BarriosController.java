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

import com.example.demo.models.Barrios;
import com.example.demo.services.BarriosService;
import com.example.demo.services.CiudadesService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Barrios" }) 			// utilizan todos los href y los redirect
@AllArgsConstructor
public class BarriosController {

    private final BarriosService service;
    private final CiudadesService ciudadesService;  

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("VistaListar", service.getAlls()); //Model es un contenedor que pasamos entre el controlador y la vista. //  "Ciudades" es una variable temp que toma los datos y los pasa al html   // getAlls() leee de la base de datos y agrega a la variable tem ara la lectuta en el html // El nombre que usás en el HTML (${algo}) debe coincidir exactamente con el que pusiste en addAttribute("algo", ...)
        return "barrios/listar";   // al terminar Spring redirige al navegador a Ciudades/listar // escribir cómo están nombradas tus carpetas y archivos en el sistema de archivos.
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("FormVistar", new Barrios()); 		// crea un objeto nuevo Ciudades con los atributos ingresados en html
       model.addAttribute("selectVistar", ciudadesService.getAlls()); 
        return "barrios/formulario";    // direccion del archibo html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Barrios barrio) {  // recibe los datos del html objeto (Clase-- variable tem html)
        service.save(barrio);		// envia a service 
        return "redirect:/Barrios";  // tiene q estar escrito igual que (path = { "/Barrios" })
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Barrios> barrio = service.getById(id); // varible local ciudad toma los datos de get id; 

        if (barrio.isPresent()) { 			// busca la id
          
            model.addAttribute("FormVistar", barrio.get());		 	// usa el objeto formVistar de mostrarformulario
            model.addAttribute("selectVistar", ciudadesService.getAlls()); // Ciudades selectVistar es un enlace con el select del formulario
            return "barrios/formulario";
        }

        return "redirect:/Barrios";   //  tiene q estar escrito igual que (path = { "/Barrios" })
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Barrios";			//  tiene q estar escrito igual que (path = { "/Barrios" })
    }
}
