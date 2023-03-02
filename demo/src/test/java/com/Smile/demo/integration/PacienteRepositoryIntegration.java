package com.Smile.demo.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import static org.hamcrest.MatcherAssert.assertThat; 
// import static org.hamcrest.Matchers.*;
import com.Smile.demo.entitys.Paciente;
import com.Smile.demo.repository.PacienteRepository;

@DataJpaTest
public class PacienteRepositoryIntegration {
    @Autowired
    PacienteRepository repository;
    
    @Test
     void testFindById(){
       Paciente enol =  repository.findById(1L).orElseThrow();
    //    assertThat(enol.getNombre(), equalTo("enol"));
    assertEquals(enol.getNombre(), "enol");


    }

}
