package com.pweb.repo;

import com.pweb.entity.Materia;
import com.pweb.service.to.MateriaTO;

import java.util.List;

public interface IMateriaRepo {
    public Materia buscarMateria(String nombre);
    void guardarMateria(Materia materia);

    public List<Materia> buscarPorCedulaEstudiante(String cedula);

    public List<Materia> buscarTodos();
    public Materia buscarMateria(Integer id);
}
