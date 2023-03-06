package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Paciente;
import com.Smile.demo.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements BaseService<Paciente> {

    private PacienteRepository repository;

    public PacienteServiceImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Paciente> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Paciente save(Paciente paciente) {
        return repository.save(paciente);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Optional<Paciente> findByDni(String dni) {
        return repository.findByDni(dni);
    }
}
