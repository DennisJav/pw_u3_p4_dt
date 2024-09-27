package com.pweb.controller;


import com.pweb.entity.Profesor;
import com.pweb.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RequestMapping(path = "/profesores")

@RestController
public class ProfesorControllerRestFul {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping(path = "/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public Profesor consultarCedula(@PathVariable String cedula){
        return this.profesorService.consultarPorCedula(cedula);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void ingresarProfesor(@RequestBody Profesor profesor){
        this.profesorService.insertarProfesor(profesor);
    }


    @PutMapping(path = "/${id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void actualizarProfesor(@RequestBody Profesor profesor, @PathVariable Integer id){
        //this.profesorService.consultarPorCedula(profesor.getCedula());
        profesor.setId(id);
        this.profesorService.actualizarProfesor(profesor);
    }



    @DeleteMapping(path = "/${cedula}")
    @ResponseStatus(HttpStatus.OK)
    public  void eliminarProfesor(@PathVariable String cedula){

        this.profesorService.eliminarProfesor(cedula);

    }


}
