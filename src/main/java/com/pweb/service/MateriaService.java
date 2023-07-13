package com.pweb.service;

import com.pweb.entity.Materia;
import com.pweb.repo.IMateriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService implements IMateriaService{

    @Autowired
    private IMateriaRepo materiaRepo;

    @Override
    public Materia buscarMateria(String nombre) {
        return this.materiaRepo.buscarMateria(nombre);
    }

    @Override
    public void guardarMateria(Materia materia) {
        this.materiaRepo.guardarMateria(materia);
    }
}
