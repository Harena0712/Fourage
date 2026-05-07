package com.fourage.service;

import com.fourage.model.Statut;
import com.fourage.repository.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatutService {

    @Autowired
    private StatutRepository repo;

    public List<Statut> getAll() {
        return repo.getAll();
    }

    public void save(Statut d) {
        repo.save(d);
    }

    public Statut getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}