package com.pweb.service;

import com.pweb.entity.Profesor;
import com.pweb.repo.IProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService implements IProfesorService{

    @Autowired
    private IProfesorRepo profesorRepo;

    @Override
    public Profesor consultarPorCedula(String cedula) {
        return this.profesorRepo.consultarPorCedula(cedula);
    }

    @Override
    public void insertarProfesor(Profesor profe) {
        this.profesorRepo.insertarProfesor(profe);
    }

    @Override
    public void eliminarProfesor(String cedula) {
        this.profesorRepo.eliminarProfesor(cedula);
    }

    @Override
    public void actualizarProfesor(Profesor profe) {
        this.profesorRepo.actualizarProfesor(profe);
    }
}
