package com.pweb.repo;


import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.pweb.entity.Estudiante;


import java.util.List;

@Repository
@Transactional
public class EstudianteRepo implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionarCedula(String cedula) {
		// TODO Auto-generated method stub

		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("Select e from Estudiante e Where e.cedula = :dato", Estudiante.class);
		myQuery.setParameter("dato", cedula);

		return myQuery.getSingleResult();
	}

	@Override
	public void crearEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void actualizarParcial(String cedulaActual , String cedulaNueva) {

		Query myQuery=this.entityManager.createQuery("UPDATE Estudiante e SET e.cedula=:datoCedula WHERE e.cedula =:datoCondicion");
		myQuery.setParameter("datoCedula", cedulaNueva);
		myQuery.setParameter("datoCedula", cedulaActual);
		myQuery.executeUpdate();


	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscarId(id));
	}

	@Override
	public Estudiante buscarId(Integer id) {
		return this.entityManager.find(Estudiante.class,id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("Select e from Estudiante e ", Estudiante.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarTodosProvincia(String provincia) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("Select e from Estudiante e where e.provincia=:dato", Estudiante.class);
		myQuery.setParameter("dato", provincia);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante insertarEstudianteDetalle(Estudiante estudiante) {
return null;
	}


}
