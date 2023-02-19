package com.Smile.demo.services;
import java.util.*;

import com.Smile.demo.entitys.Tratamiento;

public interface TratamientoService {
    
    public List<Tratamiento> findAll();

    public Optional<Tratamiento> findById(Long id);

    public Tratamiento save(Tratamiento ciudad);

    public void deleteById(Long id);
}
