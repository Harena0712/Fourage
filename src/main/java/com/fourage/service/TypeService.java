package com.fourage.service;

import com.fourage.model.Type;
import com.fourage.repository.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repo;

    public List<Type> getAll() {
        return repo.getAll();
    }

    public void save(Type type) {
        repo.save(type);
    }

    public Type getById(int id) {
        return repo.getById(id);
    }

    public void update(Type type) {
        repo.update(type);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
