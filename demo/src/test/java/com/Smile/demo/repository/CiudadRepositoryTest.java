package com.Smile.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Smile.demo.entitys.Ciudad;

@SpringBootTest
public class CiudadRepositoryTest {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Test
    public void whenSave_thenCiudadIsPersisted() {
        Ciudad ciudad = new Ciudad("Gijon");
        ciudadRepository.save(ciudad);
        assertThat(ciudad.getId()).isNotNull();

        Ciudad savedCiudad = ciudadRepository.findById(ciudad.getId()).orElse(null);
        assertThat(savedCiudad).isNotNull();
        assertThat(savedCiudad.getCiudad()).isEqualTo(ciudad.getCiudad());
    }
}

