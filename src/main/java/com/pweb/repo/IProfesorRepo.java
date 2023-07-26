package com.pweb.repo;

import com.pweb.entity.Profesor;

public interface IProfesorRepo {
    public Profesor consultarPorCedula(String cedula);
    public void insertarProfesor(Profesor profe);
    void eliminarProfesor(String cedula);
    public void actualizarProfesor(Profesor profe);

}
