package com.fourage.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaDAO {

    private final EntityManagerFactory emf;

    public JpaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Object entity) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.persist(entity);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    public <T> T getById(Class<T> clazz, Object id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(clazz, id);

        } finally {
            em.close();
        }
    }

    public <T> List<T> getAll(Class<T> clazz) {

        EntityManager em = emf.createEntityManager();

        try {

            String jpql =
                    "SELECT e FROM "
                    + clazz.getSimpleName()
                    + " e";

            return em.createQuery(jpql, clazz)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public void update(Object entity) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            em.merge(entity);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    public <T> void delete(Class<T> clazz, Object id) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            T entity = em.find(clazz, id);

            if (entity != null) {
                em.remove(entity);
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    public <T> List<T> getByQuery(String jpql, Class<T> clazz, Object... params) {

        EntityManager em = emf.createEntityManager();

        try {

            var query = em.createQuery(jpql, clazz);

            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }

            return query.getResultList();

        } finally {
            em.close();
        }
    }
}