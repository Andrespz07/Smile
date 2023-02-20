package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Paciente;
import com.Smile.demo.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

       // IMPORTANTE
       @Autowired
       private PacienteRepository pacienteRepository;
   
       // GET ALL
       @Transactional(readOnly = true)
       @Override
       public List<Paciente> findAll() {
           return pacienteRepository.findAll();
       }
   
       // GET BY ID
       @Transactional(readOnly = true)
       @Override
       public Optional<Paciente> findById(Long id) {
           return pacienteRepository.findById(id);
       }

       @Transactional
       @Override
       public Optional<Paciente> findByDni(String dni){
              return pacienteRepository.findByDni(dni);
       }
   
       // SAVE
       @Transactional
       @Override
       public Paciente save(Paciente paciente) {
           return pacienteRepository.save(paciente);
       }
   
       // DELETE BY ID
       @Transactional
       @Override
       public void deleteById(Long id) {
           pacienteRepository.deleteById(id);
       }
}
