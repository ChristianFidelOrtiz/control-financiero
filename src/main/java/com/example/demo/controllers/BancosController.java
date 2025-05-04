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

import com.example.demo.models.Bancos;
import com.example.demo.services.BancosService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Bancos" }) 			// utilizan todos los href y los redirect
@AllArgsConstructor
public class BancosController {

    private final BancosService service;
  
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("VistaListar", service.getAlls()); //Model es un contenedor que pasamos entre el controlador y la vista. //  "Ciudades" es una variable temp que toma los datos y los pasa al html   // getAlls() leee de la base de datos y agrega a la variable tem ara la lectuta en el html // El nombre que usás en el HTML (${algo}) debe coincidir exactamente con el que pusiste en addAttribute("algo", ...)
        return "bancos/listar";   // al terminar Spring redirige al navegador a Ciudades/listar // escribir cómo están nombradas tus carpetas y archivos en el sistema de archivos.
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("FormVistar", new Bancos()); 		// crea un objeto nuevo Ciudades con los atributos ingresados en html
       
        return "bancos/formulario";    // direccion del archibo html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Bancos banco) {  // recibe los datos del html objeto (Clase-- variable tem html)
        service.save(banco);		// envia a service 
        return "redirect:/Bancos";  // tiene q estar escrito igual que (path = { "/Barrios" })
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Bancos> banco = service.getById(id); // varible local ciudad toma los datos de get id; 

        if (banco.isPresent()) { 			// busca la id
          
            model.addAttribute("FormVistar", banco.get());		 	// usa el objeto formVistar de mostrarformulario
           
            return "bancos/formulario";
        }

        return "redirect:/Bancos";   //  tiene q estar escrito igual que (path = { "/Barrios" })
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/Bancos";			//  tiene q estar escrito igual que (path = { "/Barrios" })
    }
}