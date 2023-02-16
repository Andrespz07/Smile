package com.Smile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smile.demo.entitys.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
}
