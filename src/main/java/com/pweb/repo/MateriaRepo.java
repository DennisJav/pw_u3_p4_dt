package com.pweb.repo;

import com.pweb.entity.Estudiante;
import com.pweb.entity.Materia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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
}
