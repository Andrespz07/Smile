package com.Smile.demo.services;
import java.util.*;


import com.Smile.demo.entitys.Ciudad;


public interface CiudadService {
    
    public List<Ciudad> findAll();

    // public Page<Ciudad> findAll(Pageable pageables);

    public Optional<Ciudad> findById(Long id);

    public Ciudad save(Ciudad ciudad);

    public void deleteById(Long id);

}
