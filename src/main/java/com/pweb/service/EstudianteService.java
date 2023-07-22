package com.pweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.entity.Estudiante;
import com.pweb.repo.IEstudianteRepo;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public Estudiante estudianteConsultarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarCedula(cedula);
	}

	@Override
	public void guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.crearEstudiante(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {

		this.estudianteRepo.actualizarEstudiante(estudiante);
	}

	@Override
	public void actualizarParcial(String cedulaActual, String cedulaNueva) {
		this.estudianteRepo.actualizarParcial(cedulaActual,cedulaNueva);
	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepo.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		return this.estudianteRepo.buscarTodos();
	}

	@Override
	public List<Estudiante> buscarTodosProvincia(String provincia) {
		return this.estudianteRepo.buscarTodosProvincia(provincia);
	}

	@Override
	public Estudiante insertarEstudianteDetalle(Estudiante estudiante) {
		this.estudianteRepo.crearEstudiante(estudiante);
		return estudiante;
	}


}
