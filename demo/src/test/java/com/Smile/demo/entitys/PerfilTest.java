package com.Smile.demo.entitys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Smile.demo.repository.PerfilRepository;
import com.Smile.demo.repository.CiudadRepository;
import com.Smile.demo.repository.PacienteRepository;

@SpringBootTest
public class PerfilTest {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void testCreatePerfil() {
        Ciudad ciudad = new Ciudad();
        ciudad.setCiudad("Buenos Aires");
        ciudadRepository.save(ciudad);

        Paciente paciente = new Paciente();
        paciente.setDni("12345678A");
        paciente.setNombre("Walter White");
        pacienteRepository.save(paciente);

        Perfil perfil = new Perfil();
        perfil.setEdad(30);
        perfil.setDireccion("Calle Falsa 123");
        perfil.setTelefono(123456789);
        perfil.setPaciente(paciente);
        perfil.setCiudad(ciudad);

        perfilRepository.save(perfil);

        assertNotNull(perfil.getId());
        assertEquals(30, perfil.getEdad());
        assertEquals("Calle Falsa 123", perfil.getDireccion());
        assertEquals(123456789, perfil.getTelefono());
        assertEquals(paciente, perfil.getPaciente());
        assertEquals(ciudad, perfil.getCiudad());
    }
}
