package com.pweb.repo;

import com.pweb.entity.Materia;

public interface IMateriaRepo {
    public Materia buscarMateria(String nombre);
    void guardarMateria(Materia materia);
}
