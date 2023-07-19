package com.pweb.service;

import com.pweb.entity.Horario;
import com.pweb.repo.IHorarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioService implements IHorarioService{

    @Autowired
    private IHorarioRepo horarioRepo;

    @Override
    public Horario consultarPorCodigo(String codigo) {
        return this.horarioRepo.consultarPorCodigo(codigo);
    }

    @Override
    public void insertarHorario(Horario hora) {
        this.horarioRepo.insertarHorario(hora);
    }

    @Override
    public void eliminarHorario(String codigo) {
        this.horarioRepo.eliminarHorario(codigo);
    }

    @Override
    public void actualizarHorario(Horario hora) {
        this.horarioRepo.actualizarHorario(hora);
    }

    @Override
    public void actualizarParcial(String codigo, String periodo) {
        this.horarioRepo.actualizarParcial(codigo,periodo);
    }
}
