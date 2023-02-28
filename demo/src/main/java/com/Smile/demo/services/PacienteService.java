package com.Smile.demo.services;
import java.util.*;

import com.Smile.demo.entitys.Paciente;

public interface PacienteService {

    public List<Paciente> findAll();

    public Optional<Paciente> findById(Long id);

    public Optional<Paciente> findByDni(String dni);

    public Paciente save(Paciente ciudad);

    public void deleteById(Long id);
    
}
