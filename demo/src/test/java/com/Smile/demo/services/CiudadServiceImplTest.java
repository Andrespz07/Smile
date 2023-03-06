package com.Smile.demo.services;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import com.Smile.demo.entitys.Ciudad;
import com.Smile.demo.repository.CiudadRepository;

@ExtendWith(MockitoExtension.class)
public class CiudadServiceImplTest {
    @Mock
    private CiudadRepository repository;

    @InjectMocks
    private CiudadServiceImpl service;
    
    @Test
    public void testGetOneCity() {
        Ciudad gijon = new Ciudad ("Gijon");

        List<Ciudad> result = service.findAll();
        result.add(gijon);
       assertThat(result.get(0).getCiudad(), equalTo("Gijon"));
    }

}