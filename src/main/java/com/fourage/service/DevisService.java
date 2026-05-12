package com.fourage.service;

import com.fourage.model.Devis;
import com.fourage.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DevisService {

    @Autowired
    private DevisRepository repo;

    public List<Devis> getAll() {
        return repo.getAll();
    }

    public void save(Devis d) {
        repo.save(d);
    }

    public Devis getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}