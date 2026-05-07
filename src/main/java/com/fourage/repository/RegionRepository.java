package com.fourage.repository;

import com.fourage.model.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionRepository {

    private final JpaDAO jpaDAO;

    public RegionRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Region region) {
        jpaDAO.save(region);
    }

    public Region getById(int id) {
        return jpaDAO.getById(Region.class, id);
    }

    public List<Region> getAll() {
        return jpaDAO.getAll(Region.class);
    }

    public void update(Region region) {
        jpaDAO.update(region);
    }

    public void delete(int id) {
        jpaDAO.delete(Region.class, id);
    }
}
