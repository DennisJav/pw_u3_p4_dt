package com.pweb.service;

import com.pweb.entity.Profesor;

public interface IProfesorService {
    public Profesor consultarPorCedula(String cedula);
    public void insertarProfesor(Profesor profe);
    void eliminarProfesor(String cedula);
    public void actualizarProfesor(Profesor profe);
}
