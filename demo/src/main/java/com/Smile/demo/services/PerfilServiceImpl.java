package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Perfil;
import com.Smile.demo.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements BaseService<Perfil> {
    
    private PerfilRepository repository;

    public PerfilServiceImpl(PerfilRepository repository) {
        this.repository = repository;
    }
 
     @Transactional(readOnly = true)
     @Override
     public List<Perfil> findAll() {
         return repository.findAll();
     }
 
     @Transactional(readOnly = true)
     @Override
     public Optional<Perfil> findById(Long id) {
         return repository.findById(id);
     }
 
     @Transactional
     @Override
     public Perfil save(Perfil perfil) {
         return repository.save(perfil);
     }
 
     @Transactional
     @Override
     public void deleteById(Long id) {
        repository.deleteById(id);
     }
}
