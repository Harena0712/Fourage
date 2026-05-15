package com.fourage.repository;

import com.fourage.model.Devis;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DevisRepository {

    private final JpaDAO jpaDAO;

    public DevisRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Devis devis) {
        jpaDAO.save(devis);
    }

    public Devis getById(int id) {
        return jpaDAO.getById(Devis.class, id);
    }

    public List<Devis> getAll() {
        return jpaDAO.getAll(Devis.class);
    }

    public void update(Devis devis) {
        jpaDAO.update(devis);
    }

    public void delete(int id) {
        jpaDAO.delete(Devis.class, id);
    }
}
