package com.Smile.demo.services;
import java.util.*;

import com.Smile.demo.entitys.Perfil;

public interface PerfilService {

    public List<Perfil> findAll();

    public Optional<Perfil> findById(Long id);

    public Perfil save(Perfil ciudad);

    public void deleteById(Long id);
    
}
