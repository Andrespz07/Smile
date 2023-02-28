package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Tratamiento;
import com.Smile.demo.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {
    
    
    // IMPORTANTE
    @Autowired
    private TratamientoRepository tratamientoRepository;

    // GET ALL
    @Transactional(readOnly = true)
    @Override
    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    // GET BY ID
    @Transactional(readOnly = true)
    @Override
    public Optional<Tratamiento> findById(Long id) {
        return tratamientoRepository.findById(id);
    }

    // SAVE
    @Transactional
    @Override
    public Tratamiento save(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    // DELETE BY ID
    @Transactional
    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }
}
