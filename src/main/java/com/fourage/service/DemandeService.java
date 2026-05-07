package com.fourage.service;

import com.fourage.model.Demande;
import com.fourage.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository repo;

    public List<Demande> getAll() {
        return repo.getAll();
    }

    public void save(Demande d) {
        repo.save(d);
    }

    public Demande getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}