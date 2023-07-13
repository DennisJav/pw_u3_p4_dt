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





}
