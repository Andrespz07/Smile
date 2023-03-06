package com.Smile.demo.entitys;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TratamientoTest {

    @Test
    public void testSetAndGetId() {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(1L);
        assertEquals(1, tratamiento.getId());
    }

    @Test
    public void testSetAndGetTratamiento() {
        Tratamiento tratamiento = new Tratamiento();
        String nombreTratamiento = "Limpieza dental";
        tratamiento.setTratamiento(nombreTratamiento);
        assertEquals(nombreTratamiento, tratamiento.getTratamiento());
    }

    @Test
    public void testSetAndGetPacientes() {
        Tratamiento tratamiento = new Tratamiento();
        Set<Paciente> pacientes = new HashSet<>();
        Paciente paciente1 = new Paciente("Andres",  "12345678");
        Paciente paciente2 = new Paciente("Giaco", "87654321");
        pacientes.add(paciente1);
        pacientes.add(paciente2);
        tratamiento.setPacientes(pacientes);
        assertEquals(pacientes, tratamiento.getPacientes());
    }
}

