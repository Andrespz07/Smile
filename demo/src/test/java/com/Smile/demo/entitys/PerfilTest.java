package com.Smile.demo.entitys;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Smile.demo.repository.PerfilRepository;

@SpringBootTest
public class PerfilTest {

    @Autowired
    private PerfilRepository perfilRepository;

    @Test
    public void testCreatePerfil() {

        Perfil perfil = new Perfil();
        perfil.setEdad(30);
        perfil.setDireccion("Calle Falsa 123");
        perfil.setTelefono(123456789);
        
        perfilRepository.save(perfil);

        assertNotNull(perfil.getId());
        assertEquals(30, perfil.getEdad());
        assertEquals("Calle Falsa 123", perfil.getDireccion());
        assertEquals(123456789, perfil.getTelefono());
    }
}
