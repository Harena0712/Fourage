package com.fourage.service;

import com.fourage.model.DevisDetail;
import com.fourage.repository.DevisDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevisDetailService {

    @Autowired
    private DevisDetailRepository repo;

    public List<DevisDetail> getAll() {
        return repo.getAll();
    }

    public void save(DevisDetail devisDetail) {
        repo.save(devisDetail);
    }

    public DevisDetail getById(int id) {
        return repo.getById(id);
    }

    public void update(DevisDetail devisDetail) {
        repo.update(devisDetail);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}