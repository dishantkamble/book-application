package com.dishant.book.application.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dishant.book.application.model.Entity;

public class BaseRepository<T extends Entity<I>, I> {

    private Map<I, T> persistence;

    public BaseRepository(Map<I, T> persistence) {
        this.persistence = persistence;
    }

    public List<T> findAll() {
        return this.persistence.values().stream().collect(Collectors.toList());
    }

    public T findById(I id) {
        return this.persistence.get(id);
    }

    public T save(T entity) {
        return this.persistence.put(entity.getId(), entity);
    }

    public T update(T entity) {
        return this.persistence.replace(entity.getId(), entity);
    }

    public void delete(T entity) {
        this.persistence.remove(entity.getId());
    }

    public void deleteById(I id) {
        this.persistence.remove(id);
    }
}