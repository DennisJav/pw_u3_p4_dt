package com.pweb.repo;

import org.springframework.stereotype.Repository;

import com.pweb.entity.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepo implements IEstudianteRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionarCedula(String cedula) {
		// TODO Auto-generated method stub
		
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("Select e from Estudiante e Where e.cedula = :dato", Estudiante.class);
		myQuery.setParameter("dato", cedula);
		
		return myQuery.getSingleResult();
	}

	@Override
	public void crearEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
}
