package com.Smile.demo.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Smile.demo.entitys.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional <Paciente> findByDni(String dni);
    
}
