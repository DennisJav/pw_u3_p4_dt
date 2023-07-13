package com.pweb.repo;

import com.pweb.entity.Estudiante;

public interface IEstudianteRepo {

	public Estudiante seleccionarCedula(String cedula);

	void crearEstudiante(Estudiante estudiante);

}
