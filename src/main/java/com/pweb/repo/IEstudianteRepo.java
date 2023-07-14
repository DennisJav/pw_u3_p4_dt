package com.pweb.repo;

import com.pweb.entity.Estudiante;

import java.util.List;

public interface IEstudianteRepo {

	public Estudiante seleccionarCedula(String cedula);

	void crearEstudiante(Estudiante estudiante);
	
	void actualizarEstudiante(Estudiante estudiante);

	void actualizarParcial(String cedulaActual , String cedulaNueva);

	void borrar(Integer id);
	Estudiante buscarId(Integer id);

	List<Estudiante> buscarTodos();

	List<Estudiante> buscarTodosProvincia(String provincia);

}
