package com.fourage.service;

import com.fourage.model.Commune;
import com.fourage.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommuneService {

    @Autowired
    private CommuneRepository repo;

    public List<Commune> getAll() {
        return repo.getAll();
    }

    public void save(Commune d) {
        repo.save(d);
    }

    public Commune getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}