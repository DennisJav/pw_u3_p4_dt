package com.pweb.repo;

import com.pweb.entity.Horario;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HorarioRepo implements IHorarioRepo {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Horario consultarPorCodigo(String codigo) {
        TypedQuery<Horario> myQuery = this.entityManager
                .createQuery("SELECT h FROM Horario h WHERE h.codigo =:codigo", Horario.class);
        myQuery.setParameter("codigo", codigo);
        return myQuery.getSingleResult();
    }

    @Override
    public void insertarHorario(Horario hora) {
        this.entityManager.persist(hora);
    }

    @Override
    public void eliminarHorario(String codigo) {
        this.entityManager.remove(this.consultarPorCodigo(codigo));
    }

    @Override
    public void actualizarHorario(Horario hora) {
        this.entityManager.merge(hora);
    }

    @Override
    public void actualizarParcial(String codigo, String periodo) {
        Query myQuery = this.entityManager
                .createQuery("UPDATE Horario e SET e.periodo= : datoCodigo WHERE e.codigo: datoCondicion");
        myQuery.setParameter("datoCodigo", periodo);
        myQuery.setParameter("datoCondicion", codigo);
        myQuery.executeUpdate();
    }
}
