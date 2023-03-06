package com.Smile.demo.entitys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CiudadTest {

    @Test
    public void testCiudadEntity() {
        Ciudad ciudad = new Ciudad("Madrid");
        assertThat(ciudad.getCiudad()).isEqualTo("Madrid");
    }
}