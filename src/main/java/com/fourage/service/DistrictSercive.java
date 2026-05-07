package com.fourage.service;

import com.fourage.model.District;
import com.fourage.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DistrictSercive {

    @Autowired
    private DistrictRepository repo;

    public List<District> getAll() {
        return repo.getAll();
    }

    public void save(District d) {
        repo.save(d);
    }

    public District getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}