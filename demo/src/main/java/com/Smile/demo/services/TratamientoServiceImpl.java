package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Tratamiento;
import com.Smile.demo.repository.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements BaseService<Tratamiento> {
    
    private TratamientoRepository repository;

    public TratamientoServiceImpl(TratamientoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tratamiento> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Tratamiento> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Tratamiento save(Tratamiento tratamiento) {
        return repository.save(tratamiento);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
