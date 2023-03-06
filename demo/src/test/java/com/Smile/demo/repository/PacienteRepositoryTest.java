package com.Smile.demo.repository;

import com.Smile.demo.entitys.Paciente;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;

@SpringBootTest
@Transactional
@AutoConfigureTestEntityManager
public class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByDni_thenReturnPaciente() {
        // given
        Paciente paciente = new Paciente("Andres", "Pérez");
        entityManager.persist(paciente);

        // when
        Optional<Paciente> oPaciente = pacienteRepository.findByDni(paciente.getDni());

        // then
        Assertions.assertTrue(oPaciente.isPresent());
        Assertions.assertEquals(oPaciente.get().getNombre(), paciente.getNombre());
    }

}
