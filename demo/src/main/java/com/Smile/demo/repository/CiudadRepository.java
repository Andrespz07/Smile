package com.Smile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smile.demo.entitys.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    
}
