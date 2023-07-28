package com.pweb.controller;

import com.pweb.service.IMateriaService;
import com.pweb.service.to.EstudianteTO;
import com.pweb.service.to.MateriaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.pweb.entity.Estudiante;
import com.pweb.service.IEstudianteService;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;
    @Autowired
    private IMateriaService materiaService;

    // get
//	@GetMapping(path = "/{cedula}")
//
//	public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula) {
//		//return this.estudianteService.estudianteConsultarCedula(cedula);
//		// http://localhost:8080/API/Matricula/estudiantes/buscar
//		return ResponseEntity.status(227).body(this.estudianteService.estudianteConsultarCedula(cedula));
//	}


    //METODO PARA EJEMPLO
//	@GetMapping(path = "/{cedula}", produces = "application/xml")
//	@ResponseStatus(HttpStatus.OK) //esta logica se usa para algo fijo, que no ncesita mas otros cambios
//	public Estudiante consultarPorCedulaStatus(@PathVariable String cedula) {
//		return this.estudianteService.estudianteConsultarCedula(cedula);
//	}

    @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK) //esta logica se usa para algo fijo, que no ncesita mas otros cambios
    public Estudiante consultarPorCedulaStatus(@PathVariable String cedula) {
        return this.estudianteService.estudianteConsultarCedula(cedula);
    }
    //-------------------------------------

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Estudiante insertarEstudianteDetalle(@RequestBody Estudiante estudiante) {
        return this.estudianteService.insertarEstudianteDetalle(estudiante);
    }


    //-------------------------------------
    @PostMapping(consumes = "application/xml")
    public void guardar(@RequestBody Estudiante estudiante) {
        this.estudianteService.guardarEstudiante(estudiante);
        // http://localhost:8080/API/Matricula/estudiantes/guardar
    }

    @PutMapping(path = "/{identificador}")
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
        //Integer ident = 1;
        estudiante.setId(identificador);
        this.estudianteService.actualizar(estudiante);
        // http://localhost:8080/API/Matricula/estudiantes/actualizar
    }

    @PatchMapping(path = "/{identificador}")
    public void actualizaParcial(@RequestBody Estudiante estudiante, @PathVariable String cedula) {
        //Integer ident = 1;
        //estudiante.setId(identificador);
        //	this.estudianteService.actualizar(estudiante);
        Estudiante estu0 = this.estudianteService.estudianteConsultarCedula(cedula);
        estu0.setCedula(estudiante.getCedula());
        this.estudianteService.actualizar(estudiante);

        //http://localhost:8080/API/Matricula/estudiantes/actualizarParcial
    }

    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id) {
        //Integer eliminar = 1;
        this.estudianteService.eliminar(id);
        //http://localhost:8080/API/Matricula/estudiantes/borrar
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> buscar() {
        List<Estudiante> lista = this.estudianteService.buscarTodos();
        //return this.estudianteService.buscarTodos();
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("detalleMensaje", "Ciudadano consultados exitosamente");
        cabeceras.add("valorAPI", "Incalculable");
        return new ResponseEntity<>(lista, cabeceras, 228);
    }

//	@GetMapping(path = "/{provincia}")
//	public List<Estudiante> buscarTodosParametro(@RequestParam String provincia){
//		return this.estudianteService.buscarTodosProvincia(provincia);
//	}


    //------------------------------ TALLER 33

    //el path aqui no va solo es porque estoy colocando
    @GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstudianteTO>> buscarTodosHATEOAS() {
        List<EstudianteTO> lista = this.estudianteService.buscarTodosTO();
        for (EstudianteTO estudiante : lista) {
            //creacion del link automatico
            Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class)
                    .buscarPorEstudiante(estudiante.getCedula()))
                    .withRel("materias"); //el withrel indica el nombre del que va a representar

            estudiante.add(myLink);
        }
        return new ResponseEntity<>(lista, null, 200);
    }

    @GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {
        return new ResponseEntity<>(this.materiaService.buscarPorCedulaEstudiante(cedula),null,200);
    }


}
