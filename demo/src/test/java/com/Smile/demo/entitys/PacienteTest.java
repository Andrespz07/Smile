package com.Smile.demo.entitys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Smile.demo.repository.PacienteRepository;

// @DataJpaTest
@SpringBootTest
public class PacienteTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void testCreatePaciente() {
        Paciente paciente = new Paciente();
        paciente.setDni("12345678A");
        paciente.setNombre("Walter White");
        pacienteRepository.save(paciente);

        assertNotNull(paciente.getDni());
        assertEquals("12345678A", paciente.getDni());
        assertNotNull(paciente.getNombre());
        assertEquals("Walter White", paciente.getNombre());
    }

}
