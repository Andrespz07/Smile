package com.Smile.demo.services;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    public List<T> findAll();

    public Optional<T> findById(Long id);

    public T save(T entity);

    public void deleteById(Long id);
}


