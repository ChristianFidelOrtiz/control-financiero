package com.example.demo.controllers;

import com.example.demo.models.AperturaCierreCaja;
import com.example.demo.services.AperturaCierreCajaService;
import com.example.demo.services.CajasService;
import com.example.demo.services.SucursalesService;
import com.example.demo.services.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/AperturaCierreCaja")
@AllArgsConstructor
public class AperturaCierreCajaController {

    private final AperturaCierreCajaService service;
    private final CajasService cajasService;
    private final UsuariosService usuariosService;
    private final SucursalesService sucursalesService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vistaListaCajas", service.getAlls());
        return "aperturaCierreCaja/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("formCaja", new AperturaCierreCaja());
        model.addAttribute("listaCajas", cajasService.getAlls());
        model.addAttribute("listaUsuarios", usuariosService.getAlls());
        model.addAttribute("listaSucursales", sucursalesService.getAlls());
        return "aperturaCierreCaja/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute AperturaCierreCaja caja) {
        service.save(caja);
        return "redirect:/AperturaCierreCaja";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Optional<AperturaCierreCaja> caja = service.getById(id);

        if (caja.isPresent()) {
            model.addAttribute("formCaja", caja.get());
            model.addAttribute("listaCajas", cajasService.getAlls());
            model.addAttribute("listaUsuarios", usuariosService.getAlls());
            model.addAttribute("listaSucursales", sucursalesService.getAlls());
            return "aperturaCierreCaja/formulario";
        }

        return "redirect:/AperturaCierreCaja";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer id) {
        service.delete(id);
        return "redirect:/AperturaCierreCaja";
    }
}
