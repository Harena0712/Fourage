package com.fourage.repository;

import com.fourage.model.Demande;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemandeRepository {

    private final JpaDAO jpaDAO;

    public DemandeRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Demande demande) {
        jpaDAO.save(demande);
    }

    public Demande getById(int id) {
        return jpaDAO.getById(Demande.class, id);
    }

    public List<Demande> getAll() {
        return jpaDAO.getAll(Demande.class);
    }

    public void update(Demande demande) {
        jpaDAO.update(demande);
    }

    public void delete(int id) {
        jpaDAO.delete(Demande.class, id);
    }

}