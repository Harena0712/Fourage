package com.fourage.repository;

import com.fourage.model.Commune;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommuneRepository {

    private final JpaDAO jpaDAO;

    public CommuneRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Commune commune) {
        jpaDAO.save(commune);
    }

    public Commune getById(int id) {
        return jpaDAO.getById(Commune.class, id);
    }

    public List<Commune> getAll() {
        return jpaDAO.getAll(Commune.class);
    }

    public void update(Commune commune) {
        jpaDAO.update(commune);
    }  

    public void delete(int id) {
        jpaDAO.delete(Commune.class, id);
    }
}
