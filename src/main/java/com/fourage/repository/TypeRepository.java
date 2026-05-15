package com.fourage.repository;

import com.fourage.model.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeRepository {

    private final JpaDAO jpaDAO;

    public TypeRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Type type) {
        jpaDAO.save(type);
    }

    public Type getById(int id) {
        return jpaDAO.getById(Type.class, id);
    }

    public List<Type> getAll() {
        return jpaDAO.getAll(Type.class);
    }

    public void update(Type type) {
        jpaDAO.update(type);
    }

    public void delete(int id) {
        jpaDAO.delete(Type.class, id);
    }
}