package com.pweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.entity.Estudiante;
import com.pweb.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	//get
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1721233465";		
		return this.estudianteService.estudianteConsultarCedula(cedula);
	}

}
