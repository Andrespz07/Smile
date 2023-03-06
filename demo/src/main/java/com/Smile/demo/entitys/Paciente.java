package com.Smile.demo.entitys;

import java.util.Set;

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

    public Paciente() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public Paciente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Set<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Set<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pacientes_tratamientos", 
    joinColumns = @JoinColumn(name = "paciente_id"),
    inverseJoinColumns = @JoinColumn(name = "tratamiento_id"))
    Set<Tratamiento> tratamientos;
}
