package com.pweb.repo;

import com.pweb.entity.Estudiante;
import com.pweb.entity.Profesor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProfesorRepo implements IProfesorRepo {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Profesor consultarPorCedula(String cedula) {
        TypedQuery<Profesor> myQuery = this.entityManager
                .createQuery("Select p from Profesor p Where p.cedula = :dato", Profesor.class);
        myQuery.setParameter("dato", cedula);
        return myQuery.getSingleResult();
    }

    @Override
    public void insertarProfesor(Profesor profe) {
        this.entityManager.persist(profe);
    }

    @Override
    public void eliminarProfesor(String cedula) {
        this.entityManager.remove(this.consultarPorCedula(cedula));
    }

    @Override
    public void actualizarProfesor(Profesor profe) {
        this.entityManager.merge(profe);
    }
}
