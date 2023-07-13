package com.pweb.entity;

import jakarta.persistence.*;

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
    @Column(name = "mate_semestre")
    private String semestre;
    @Column(name = "mate_paralelo")
    private String paralelo;
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
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getParalelo() {
		return paralelo;
	}
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", semestre=" + semestre + ", paralelo=" + paralelo + "]";
	}


    



}
