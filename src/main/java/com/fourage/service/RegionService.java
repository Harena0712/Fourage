package com.fourage.service;

import com.fourage.model.Region;
import com.fourage.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegionService {

    @Autowired
    private RegionRepository repo;

    public List<Region> getAll() {
        return repo.getAll();
    }

    public void save(Region d) {
        repo.save(d);
    }

    public Region getById(int id) {
        return repo.getById(id);
    }

    public void delete(int id) {
        repo.delete(id);
    }
}