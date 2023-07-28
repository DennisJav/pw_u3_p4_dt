package com.pweb.entity;

import jakarta.persistence.*;
import jdk.jfr.MemoryAddress;

import java.time.LocalDateTime;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_mate")
    @SequenceGenerator(name = "sec_id_mate", sequenceName = "sec_id_mate", allocationSize = 1)
    @Column(name = "mate_id")
    private int id;
    @Column(name = "mate_nombre")
    private String nombre;


	@Column(name = "mate_num_credito")
	private Integer numeroCredito;


	@ManyToOne
	@JoinColumn(name = "mate_id_estudiante")
	private Estudiante estudiante;

	//metodos get y set relacion
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

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


	public Integer getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(Integer numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	@Override
	public String toString() {
		return "Materia{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", numeroCredito=" + numeroCredito +
				'}';
	}
}
