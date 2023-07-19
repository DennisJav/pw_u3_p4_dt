package com.pweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @Column(name = "hora_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
    @SequenceGenerator(name = "name_generator", sequenceName = "hora_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "hora_codigo")
    private String codigo;
    @Column(name = "hora_carrera")
    private String carrera;
    @Column(name = "hora_cantidad_materias")
    private Integer cantidadMaterias;
    @Column(name = "hora_periodo")
    private String periodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", carrera='" + carrera + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
