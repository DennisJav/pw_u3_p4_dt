package com.pweb.service;

import com.pweb.entity.Horario;

public interface IHorarioService {

    Horario consultarPorCodigo(String codigo);

    void insertarHorario(Horario hora);

    void eliminarHorario(String codigo);

    void actualizarHorario(Horario hora);

    void actualizarParcial(String codigo, String periodo);

}
