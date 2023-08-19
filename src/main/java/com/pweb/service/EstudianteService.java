package com.pweb.service;

import com.pweb.service.to.EstudianteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pweb.entity.Estudiante;
import com.pweb.repo.IEstudianteRepo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public Estudiante estudianteConsultarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarCedula(cedula);
	}

	@Override
	public void guardarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.estudianteRepo.crearEstudiante(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {

		this.estudianteRepo.actualizarEstudiante(estudiante);
	}

	@Override
	public Estudiante buscarId(Integer id) {
		return this.estudianteRepo.buscarId(id);
	}

	@Override
	public void actualizarParcial(String cedulaActual, String cedulaNueva) {
		this.estudianteRepo.actualizarParcial(cedulaActual,cedulaNueva);
	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepo.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		return this.estudianteRepo.buscarTodos();
	}

	@Override
	public List<Estudiante> buscarTodosProvincia(String provincia) {
		return this.estudianteRepo.buscarTodosProvincia(provincia);
	}

	@Override
	public Estudiante insertarEstudianteDetalle(Estudiante estudiante) {
		this.estudianteRepo.crearEstudiante(estudiante);
		return estudiante;
	}

	//------------------------------TALLER 33-----------------------------------
	@Override
	public List<EstudianteTO> buscarTodosTO() {
		List<Estudiante> lista = estudianteRepo.buscarTodos();
		List<EstudianteTO> listaTO = lista.stream().map( e ->{
			EstudianteTO est = new EstudianteTO();
			est.setId(e.getId());
			est.setApellido(e.getApellido());
			est.setCedula(e.getCedula());
			est.setProvincia(e.getProvincia());
			est.setNombre(e.getNombre());
			return est;
		}).collect(Collectors.toList());

		return listaTO;
	}

//	private EstudianteTO convertir(Estudiante e){
//
//		EstudianteTO est = new EstudianteTO();
//		est.setId(e.gettId());
//		est.setApellido(e.getApellido());
//	}

}
