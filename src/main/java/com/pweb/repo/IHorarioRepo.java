package com.pweb.repo;

import com.pweb.entity.Horario;

public interface IHorarioRepo {

    Horario consultarPorCodigo(String codigo);

    void insertarHorario(Horario hora);

    void eliminarHorario(String codigo);

    void actualizarHorario(Horario hora);

    void actualizarParcial(String codigo, String periodo);


}
