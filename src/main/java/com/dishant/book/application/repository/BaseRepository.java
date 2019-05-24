package com.dishant.book.application.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dishant.book.application.model.Entity;

public class BaseRepository<T extends Entity<ID>, ID> {

    private Map<ID, T> persistence;

    public BaseRepository(Map<ID, T> persistence) {
        this.persistence = persistence;
    }

    public List<T> findAll() {
        return this.persistence.values().stream().collect(Collectors.toList());
    }

    public T findById(ID id) {
        return this.persistence.get(id);
    }

    public T save(T t) {
        return this.persistence.put(t.getId(), t);
    }

    public T update(T t) {
        return this.persistence.replace(t.getId(), t);
    }

    public void delete(T t) {
        this.persistence.remove(t.getId());
    }

    public void deleteById(ID id) {
        this.persistence.remove(id);
    }
}