package com.pweb.repo;

import com.pweb.entity.Estudiante;
import org.springframework.stereotype.Repository;

import com.pweb.entity.Materia;


import javax.persistence.*;
import javax.transaction.Transactional;


import java.util.List;

@Repository
@Transactional
public class MateriaRepo implements IMateriaRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Materia buscarMateria(String nombre) {
        TypedQuery<Materia> myQuery = this.entityManager
                .createQuery("Select m from Materia m Where m.nombre = :dato", Materia.class);
        myQuery.setParameter("dato", nombre);

        return myQuery.getSingleResult();
    }



    @Override
    public void guardarMateria(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    public List<Materia> buscarPorCedulaEstudiante(String cedula) {
        TypedQuery<Materia> myQuery = this.entityManager
                .createQuery("Select m from Materia m Where m.estudiante.cedula = :dato", Materia.class);
        myQuery.setParameter("dato", cedula);
        return myQuery.getResultList();
    }

    @Override
    public List<Materia> buscarTodos() {
        TypedQuery<Materia> myQuery = this.entityManager
                .createQuery("Select e from Materia e ", Materia.class);

        return myQuery.getResultList();
    }

    @Override
    public Materia buscarMateria(Integer id) {
        return this.entityManager.find(Materia.class,id);
    }
}
