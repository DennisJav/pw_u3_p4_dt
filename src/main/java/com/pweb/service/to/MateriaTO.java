package com.pweb.service.to;


import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class MateriaTO extends RepresentationModel implements Serializable {

    private Integer id;
    private String nombre;
    private Integer numeroCredito;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
