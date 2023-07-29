package com.pweb.controller;

import com.pweb.entity.Materia;
import com.pweb.service.IMateriaService;
import com.pweb.service.to.EstudianteTO;
import com.pweb.service.to.MateriaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

//    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<MateriaTO>> buscarMateriaHATEOAS() {
//
//        List<MateriaTO> lista = this.materiaService.buscarTodos();
//        for (MateriaTO materia : lista) {
//            //creacion del link automatico
//            Link myLink = linkTo(methodOn(MateriaControllerRestFul.class)
//                    .buscarPorID(materia.getId()))
//                    .withRel("materias"); //el withrel indica el nombre del que va a representar
//            materia.add(myLink);
//        }
//        return new ResponseEntity<>(lista, null, 200);
//    }

    @GetMapping(path = "/{identificador}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaTO> buscarPorID(@PathVariable Integer id) {
        return new ResponseEntity<>(this.materiaService.buscarMateriaTO(id),null,200);
    }


}
