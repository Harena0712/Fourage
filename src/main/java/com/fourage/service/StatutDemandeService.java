package com.fourage.service;

import com.fourage.model.StatutDemande;
import com.fourage.repository.StatutDemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatutDemandeService {

    @Autowired
    private StatutDemandeRepository repo;

    public List<StatutDemande> getAll() {
        return repo.getAll();
    }

    public void save(StatutDemande d) {
        repo.save(d);
    }

    public StatutDemande getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}