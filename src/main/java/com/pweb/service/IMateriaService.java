package com.pweb.service;

import com.pweb.entity.Materia;

public interface IMateriaService {
    public Materia buscarMateria(String nombre);
    void guardarMateria(Materia materia);
}
