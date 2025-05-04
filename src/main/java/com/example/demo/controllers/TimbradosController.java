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

import com.example.demo.models.Timbrados;
import com.example.demo.services.TimbradosService;
import com.example.demo.services.TipoDeDocumentoService; // Asegúrate de tener este servicio
import com.example.demo.services.SucursalesService; // Asegúrate de tener este servicio
import com.example.demo.services.CajasService; // Asegúrate de tener este servicio
import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "/Timbrados" })
@AllArgsConstructor
public class TimbradosController {

    private final TimbradosService service;
    private final TipoDeDocumentoService tipoDocumentosService; // Servicio para TipoDocumentos
    private final SucursalesService sucursalesService; // Servicio para Sucursales
  private final CajasService cajasService; // Servicio para Cajas

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("VistaListar", service.getAlls()); // Obtenemos todos los timbrados
        return "timbrados/listar"; // Redirige a la vista de listar
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("FormVistar", new Timbrados()); // Creamos un nuevo objeto de Timbrado
       model.addAttribute("listaTipos", tipoDocumentosService.getAlls()); // Lista de tipos de documentos
        model.addAttribute("listaSucursales", sucursalesService.getAlls()); // Lista de sucursales
       model.addAttribute("listaCajas", cajasService.getAlls()); // Lista de cajas
        return "timbrados/formulario"; // Redirige al formulario
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Timbrados timbrado) {
        service.save(timbrado); // Guardamos el nuevo timbrado
        return "redirect:/Timbrados"; // Redirige a la lista de timbrados
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Timbrados> timbrado = service.getById(id); // Obtenemos el timbrado por id

        if (timbrado.isPresent()) {
            model.addAttribute("FormVistar", timbrado.get()); // Llenamos el formulario con el timbrado encontrado
            model.addAttribute("listaTipos", tipoDocumentosService.getAlls()); // Lista de tipos de documentos
            model.addAttribute("listaSucursales", sucursalesService.getAlls()); // Lista de sucursales
          model.addAttribute("listaCajas", cajasService.getAlls()); // Lista de cajas
            return "timbrados/formulario"; // Redirige al formulario de edición
        }

        return "redirect:/Timbrados"; // Si no se encuentra el timbrado, redirige a la lista
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.delete(id); // Eliminamos el timbrado
        return "redirect:/Timbrados"; // Redirige a la lista de timbrados
    }
}
