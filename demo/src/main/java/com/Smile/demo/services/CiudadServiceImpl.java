package com.Smile.demo.services;
import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Ciudad;
import com.Smile.demo.repository.CiudadRepository;


@Service
public class CiudadServiceImpl implements CiudadService{

    // IMPORTANTE
    @Autowired
    private CiudadRepository ciudadRepository;

    // GET ALL
    @Transactional(readOnly = true)
    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    // GET BY ID
    @Transactional(readOnly = true)
    @Override
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    // SAVE
    @Transactional
    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    // DELETE BY ID
    @Transactional
    @Override
    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }

}
