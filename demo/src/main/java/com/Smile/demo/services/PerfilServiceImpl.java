package com.Smile.demo.services;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Smile.demo.entitys.Perfil;
import com.Smile.demo.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {
    
     // IMPORTANTE
     @Autowired
     private PerfilRepository perfilRepository;
 
     // GET ALL
     @Transactional(readOnly = true)
     @Override
     public List<Perfil> findAll() {
         return perfilRepository.findAll();
     }
 
     // GET BY ID
     @Transactional(readOnly = true)
     @Override
     public Optional<Perfil> findById(Long id) {
         return perfilRepository.findById(id);
     }
 
     // SAVE
     @Transactional
     @Override
     public Perfil save(Perfil perfil) {
         return perfilRepository.save(perfil);
     }
 
     // DELETE BY ID
     @Transactional
     @Override
     public void deleteById(Long id) {
         perfilRepository.deleteById(id);
     }
}
