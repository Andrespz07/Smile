package com.Smile.demo.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Smile.demo.entitys.Ciudad;
import com.Smile.demo.services.CiudadServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CiudadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CiudadServiceImpl ciudadService;

    @Autowired
    private ObjectMapper objectMapper;

    private Ciudad ciudad;

    @BeforeEach
    public void setUp() {
        ciudad = new Ciudad();
        ciudad.setId(1L);
        ciudad.setCiudad("Buenos Aires");
    }

    @Test
    public void testGetCiudadById() throws Exception {
        Mockito.when(ciudadService.findById(ciudad.getId())).thenReturn(java.util.Optional.of(ciudad));

        MvcResult mvcResult = mockMvc.perform(get("/api/ciudad/{id}", ciudad.getId()))
                .andExpect(status().isOk()).andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        String expectedResponseBody = objectMapper.writeValueAsString(ciudad);

        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(expectedResponseBody);
    }

    @Test
    public void testCreateCiudad() throws Exception {
        // Crear el objeto Ciudad a enviar en la solicitud POST
        Ciudad ciudad = new Ciudad();
        ciudad.setCiudad("Buenos Aires");
    
        // Convertir el objeto Ciudad a un JSON String
        ObjectMapper objectMapper = new ObjectMapper();
        String ciudadJson = objectMapper.writeValueAsString(ciudad);
    
        // Enviar una solicitud POST simulada con MockMvc
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/ciudad")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ciudadJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    
        // Verificar la respuesta del servidor
        String expectedResponse = "{\"id\":1,\"ciudad\":\"Buenos Aires\"}";
        MockHttpServletResponse actualResponse = result.getResponse();
        assertEquals(201, actualResponse.getStatus());
    }

    @Test
    public void testUpdateCiudad() throws Exception {
        Mockito.when(ciudadService.findById(ciudad.getId())).thenReturn(java.util.Optional.of(ciudad));
        ciudad.setCiudad("New York");

        mockMvc.perform(put("/api/ciudad/{id}", ciudad.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ciudad))).andExpect(status().isCreated()).andReturn();

        Mockito.verify(ciudadService, Mockito.times(1)).save(ciudad);
    }

    @Test
    public void testDeleteCiudad() throws Exception {
        Mockito.when(ciudadService.findById(ciudad.getId())).thenReturn(java.util.Optional.of(ciudad));

        mockMvc.perform(delete("/api/ciudad/{id}", ciudad.getId())).andExpect(status().isOk()).andReturn();

        Mockito.verify(ciudadService, Mockito.times(1)).deleteById(ciudad.getId());
    }
}