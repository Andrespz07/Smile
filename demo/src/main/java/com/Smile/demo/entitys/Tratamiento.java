package com.Smile.demo.entitys;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tratamientos")
public class Tratamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String tratamiento;

}
