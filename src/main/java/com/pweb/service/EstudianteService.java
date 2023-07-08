package com.pweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.entity.Estudiante;
import com.pweb.repo.IEstudianteRepo;

@Service
public class EstudianteService implements IEstudianteService{

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	
	@Override
	public Estudiante estudianteConsultarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarCedula(cedula);
	}
	
	

}
