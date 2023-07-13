package com.pweb.service;

import org.springframework.stereotype.Service;

import com.pweb.entity.Estudiante;

public interface IEstudianteService {

	public Estudiante estudianteConsultarCedula(String cedula);
	void guardarEstudiante(Estudiante estudiante);
	
}
