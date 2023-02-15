package com.Smile.demo.entitys;

import javax.persistence.*;

@Entity
@Table(name="perfiles")
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private Integer edad;

    @Column(length=50, nullable = false)
    private String direccion;

    @Column(length=50, nullable = false)
    private Integer telefono;    

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ciudad_id", nullable = false)
    Ciudad ciudad;
}
