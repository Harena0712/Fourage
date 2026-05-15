package com.fourage.repository;

import com.fourage.model.DevisDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DevisDetailRepository {

    private final JpaDAO jpaDAO;

    public DevisDetailRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(DevisDetail devisDetail) {
        jpaDAO.save(devisDetail);
    }

    public DevisDetail getById(int id) {
        return jpaDAO.getById(DevisDetail.class, id);
    }

    public List<DevisDetail> getAll() {
        return jpaDAO.getAll(DevisDetail.class);
    }

    public void update(DevisDetail devisDetail) {
        jpaDAO.update(devisDetail);
    }

    public void delete(int id) {
        jpaDAO.delete(DevisDetail.class, id);
    }
}
