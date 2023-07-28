package com.pweb.service;

import com.pweb.entity.Materia;
import com.pweb.service.to.MateriaTO;

import java.util.List;

public interface IMateriaService {
    public Materia buscarMateria(String nombre);
    void guardarMateria(Materia materia);

    public List<MateriaTO> buscarPorCedulaEstudiante(String cedula);

    public MateriaTO buscarMateriaTO(Integer id);

    public List<MateriaTO> buscarTodos();
}
