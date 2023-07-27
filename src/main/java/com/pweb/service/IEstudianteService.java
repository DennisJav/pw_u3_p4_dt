package com.pweb.service;

import com.pweb.service.to.EstudianteTO;
import org.springframework.stereotype.Service;

import com.pweb.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {

	public Estudiante estudianteConsultarCedula(String cedula);
	void guardarEstudiante(Estudiante estudiante);
	void actualizar(Estudiante estudiante);

	void actualizarParcial(String cedulaActual, String cedulaNueva);

	void eliminar(Integer id);

	List<Estudiante> buscarTodos();
	List<Estudiante> buscarTodosProvincia(String provincia);

	Estudiante insertarEstudianteDetalle(Estudiante estudiante);
	public List<EstudianteTO> buscarTodosTO();
}
