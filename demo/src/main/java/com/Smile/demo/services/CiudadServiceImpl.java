package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Ciudad;
import com.Smile.demo.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements BaseService<Ciudad> {

    private CiudadRepository repository;

    public CiudadServiceImpl(CiudadRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @Transactional(readOnly = true)
    @Override
    public List<Ciudad> findAll() {
        return repository.findAll();
    }

    // GET BY ID
    @Transactional(readOnly = true)
    @Override
    public Optional<Ciudad> findById(Long id) {
        return repository.findById(id);
    }

    // SAVE
    @Transactional
    @Override
    public Ciudad save(Ciudad ciudad) {
        return repository.save(ciudad);
    }

    // DELETE BY ID
    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
