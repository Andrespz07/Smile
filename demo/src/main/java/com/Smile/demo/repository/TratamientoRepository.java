package com.Smile.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smile.demo.entitys.Tratamiento;

public interface TratamientoRepository extends JpaRepository<Tratamiento,Long> {
    
}
