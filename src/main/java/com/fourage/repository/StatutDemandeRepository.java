package com.fourage.repository;

import com.fourage.model.StatutDemande;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatutDemandeRepository {

    private final JpaDAO jpaDAO;

    public StatutDemandeRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(StatutDemande statutDemande) {
        jpaDAO.save(statutDemande);
    }

    public StatutDemande getById(int id) {
        return jpaDAO.getById(StatutDemande.class, id);
    }

    public List<StatutDemande> getAll() {
        return jpaDAO.getAll(StatutDemande.class);
    }

    public void update(StatutDemande statutDemande) {
        jpaDAO.update(statutDemande);
    }

    public void delete(int id) {
        jpaDAO.delete(StatutDemande.class, id);
    }
}