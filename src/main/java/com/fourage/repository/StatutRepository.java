package com.fourage.repository;

import com.fourage.model.Statut;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatutRepository {

    private final JpaDAO jpaDAO;

    public StatutRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Statut statut) {
        jpaDAO.save(statut);
    }

    public Statut getById(int id) {
        return jpaDAO.getById(Statut.class, id);
    }

    public List<Statut> getAll() {
        return jpaDAO.getAll(Statut.class);
    }

    public void update(Statut statut) {
        jpaDAO.update(statut);
    }

    public void delete(int id) {
        jpaDAO.delete(Statut.class, id);
    }
}