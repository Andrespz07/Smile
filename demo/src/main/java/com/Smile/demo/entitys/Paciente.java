package com.Smile.demo.entitys;

import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    private String dni;

    @Column(length = 50, nullable = false)
    private String nombre;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente() {
    }

    
}
