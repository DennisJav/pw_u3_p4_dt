package com.pweb.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="estudiante")
@JsonIgnoreProperties(value = "materias")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_estu")
	@SequenceGenerator(name = "sec_id_estu", sequenceName = "sec_id_estu", allocationSize = 1)
	@Column(name = "estu_id")
	private int id;
	@Column(name = "estu_cedula")
	private String cedula;
	@Column(name = "estu_nombre")
	private String nombre;
	@Column(name = "estu_apellido")
	private String apellido;
	@Column(name = "estu_provincia")
	private String provincia;
	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;

	@OneToMany(mappedBy = "estudiante")
	private List<Materia> materias;

	//GET Y SET DE RELACIONES
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}


	//get y set
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Estudiante{" +
				"id=" + id +
				", cedula='" + cedula + '\'' +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", provincia='" + provincia + '\'' +
				", fechaNacimiento=" + fechaNacimiento +
				", materias=" + materias +
				'}';
	}
}
