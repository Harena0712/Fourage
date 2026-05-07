package com.fourage.repository;

import com.fourage.model.District;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DistrictRepository {
    private final JpaDAO jpaDAO;

    public DistrictRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(District district) {
        jpaDAO.save(district);
    }

    public District getById(int id) {
        return jpaDAO.getById(District.class, id);
    }

    public void update(District district) {
        jpaDAO.update(district);
    }

    public void delete(int id) {
        jpaDAO.delete(District.class, id);
    }

    public List<District> getAll() {
        return jpaDAO.getAll(District.class);
    }
}
