package com.pweb.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class Profesor {

    @Id

    @Column(name = "profe_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "profe_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "profe_cedula")
    private String cedula;
    @Column(name = "profe_nombre")
    private String nombre;
    @Column(name = "profe_apellido")
    private String apellido;
    @Column(name = "profe_materia")
    private BigDecimal materia;
    @Column(name = "profe_paralelos")
    private Integer paralelos;


    //get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public BigDecimal getMateria() {
        return materia;
    }

    public void setMateria(BigDecimal materia) {
        this.materia = materia;
    }

    public Integer getParalelos() {
        return paralelos;
    }

    public void setParalelos(Integer paralelos) {
        this.paralelos = paralelos;
    }


    //to string


    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", materia=" + materia +
                ", paralelos=" + paralelos +
                '}';
    }
}
