package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Paises;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Paises")
@AllArgsConstructor
public class PaisesController {

	private final PaisesService service;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("Paises", service.getAlls());
		return "paises/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("paises", new Paises()); 
		return "paises/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Paises pais) {
		service.save(pais);
		return "redirect:/Paises";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Paises> pais = service.getById(id);

		if (pais.isPresent()) {
			model.addAttribute("paises", pais.get()); 
			return "paises/formulario";
		}

		return "redirect:/Paises";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		service.delete(id);
		return "redirect:/Paises";
	}
}