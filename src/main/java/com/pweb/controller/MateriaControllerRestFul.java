package com.pweb.controller;

import com.pweb.entity.Materia;
import com.pweb.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

    @Autowired
    private IMateriaService materiaService;

    @GetMapping(path = "/buscarMateria")
    public Materia buscarMateria(){
        String nombre = "Web";
        return this.materiaService.buscarMateria("Web");
        //http://localhost:8080/API/Matricula/materias/buscarMateria
    }

    @PostMapping(path = "/guardarMateria")
    public void guardarMateria(@RequestBody Materia materia){
        this.materiaService.guardarMateria(materia);
      //http://localhost:8080/API/Matricula/materias/guardarMateria
        
    }

}
