package com.fourage.service;

import com.fourage.model.Client;
import com.fourage.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public List<Client> getAll() {
        return repo.getAll();
    }

    public void save(Client d) {
        repo.save(d);
    }

    public Client getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }

    public List<Client> getByNomPrenom(String nom, String prenom) {
        return repo.getByNomPrenom(nom, prenom);
    }
}