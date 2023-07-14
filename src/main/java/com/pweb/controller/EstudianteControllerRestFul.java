package com.pweb.controller;

import com.pweb.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pweb.entity.Estudiante;
import com.pweb.service.IEstudianteService;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// get
	@GetMapping(path = "/buscar/{cedula}")
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		//String cedula = "1721334686";
		return this.estudianteService.estudianteConsultarCedula(cedula);
		// http://localhost:8080/API/Matricula/estudiantes/buscar

	}

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardarEstudiante(estudiante);
		// http://localhost:8080/API/Matricula/estudiantes/guardar
	}

	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante,@PathVariable Integer identificador) {
		//Integer ident = 1;
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
		// http://localhost:8080/API/Matricula/estudiantes/actualizar
	}

	@PatchMapping(path = "/actualizarParcial/{identificador}")
	public void actualizaParcial(@RequestBody Estudiante estudiante, @PathVariable String cedula) {
		//Integer ident = 1;
		//estudiante.setId(identificador);
	//	this.estudianteService.actualizar(estudiante);
		Estudiante estu0 = this.estudianteService.estudianteConsultarCedula(cedula);
		estu0.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(estudiante);

		//http://localhost:8080/API/Matricula/estudiantes/actualizarParcial
	}

	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		//Integer eliminar = 1;
		this.estudianteService.eliminar(id);
		//http://localhost:8080/API/Matricula/estudiantes/borrar
	}

	@GetMapping(path = "/todos")
	public List<Estudiante> buscarTodos(){
		return this.estudianteService.buscarTodos();
	}

	@GetMapping(path = "/todosParametro")
	public List<Estudiante> buscarTodosParametro(@RequestParam String provincia){
		return this.estudianteService.buscarTodosProvincia(provincia);
	}

}
