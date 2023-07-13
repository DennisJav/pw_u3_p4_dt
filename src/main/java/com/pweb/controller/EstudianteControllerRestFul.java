package com.pweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.entity.Estudiante;
import com.pweb.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// get
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1721334686";
		return this.estudianteService.estudianteConsultarCedula(cedula);
		// http://localhost:8081/API/Matricula/estudiantes/buscar

	}

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		// http://localhost:8081/API/Matricula/estudiantes/guardar
	}

	@PutMapping(path = "/actualizar")
	public void actualizar() {

	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizaParcial() {

	}

	@DeleteMapping(path = "/borrar")
	public void borrar() {

	}

}
