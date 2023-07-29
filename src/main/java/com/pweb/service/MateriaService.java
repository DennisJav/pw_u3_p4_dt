package com.pweb.service;

import com.pweb.entity.Materia;
import com.pweb.repo.IMateriaRepo;
import com.pweb.service.to.MateriaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriaService implements IMateriaService {

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

    @Override
    public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {

        List<Materia> lista = this.materiaRepo.buscarPorCedulaEstudiante(cedula);
        List<MateriaTO> mate = lista.stream().map(e -> {
            MateriaTO m = new MateriaTO();
            m.setId(e.getId());
            m.setNumeroCredito(e.getNumeroCredito());
            m.setNombre(e.getNombre());
            return m;
        }).collect(Collectors.toList());
        return mate;
    }

    @Override
    public MateriaTO buscarMateriaTO(Integer id) {
        Materia m = this.materiaRepo.buscarMateria(id);
        MateriaTO mate = new MateriaTO();
        mate.setId(m.getId());
        mate.setNombre(m.getNombre());
        mate.setNumeroCredito(m.getNumeroCredito());
        return mate;
    }

    @Override
    public List<MateriaTO> buscarTodos() {

        List<Materia> lista = this.materiaRepo.buscarTodos();
        List<MateriaTO> mate = lista.stream().map(e -> {
            MateriaTO m = new MateriaTO();
            m.setId(e.getId());
            m.setNumeroCredito(e.getNumeroCredito());
            m.setNombre(e.getNombre());
            return m;
        }).collect(Collectors.toList());
        return mate;
    }


}
