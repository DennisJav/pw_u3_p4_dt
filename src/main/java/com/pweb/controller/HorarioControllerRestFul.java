package com.pweb.controller;

import com.pweb.entity.Horario;
import com.pweb.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/horarios")
public class HorarioControllerRestFul {
    @Autowired
    private IHorarioService horaService;


    @GetMapping(path = "/{codigo}")
    public Horario consultarPorCodigo(@PathVariable String codigo) {
        return this.horaService.consultarPorCodigo(codigo);
    }

    @PostMapping
    public void ingresarHorario(@RequestBody Horario hora) {
        this.horaService.insertarHorario(hora);
    }

    @PatchMapping(path = "/{codigo}")
    public void actualizarParcialHorario(@RequestBody Horario hora, @PathVariable String codigo) {
        Horario hora1 = this.horaService.consultarPorCodigo(codigo);
        hora1.setPeriodo(hora.getPeriodo());
        this.horaService.actualizarHorario(hora1);
    }

    @PutMapping(path = "/{id}")
    public void actualizarHorario(@RequestBody Horario hora, @PathVariable Integer id) {
        hora.setId(id);
        this.horaService.actualizarHorario(hora);
    }

    @DeleteMapping(path = "/{codigo}")
    public void borrarPorCodigo(@PathVariable String codigo) {
        this.horaService.eliminarHorario(codigo);
    }



}
