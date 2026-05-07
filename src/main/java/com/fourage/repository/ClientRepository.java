package com.fourage.repository;

import com.fourage.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    private final JpaDAO jpaDAO;

    public ClientRepository(JpaDAO jpaDAO) {
        this.jpaDAO = jpaDAO;
    }

    public void save(Client client) {
        jpaDAO.save(client);
    }

    public Client getById(int id) {
        return jpaDAO.getById(Client.class, id);
    }

    public List<Client> getAll() {
        return jpaDAO.getAll(Client.class);
    }

    public void update(Client client) {
        jpaDAO.update(client);
    }

    public void delete(int id) {
        jpaDAO.delete(Client.class, id);
    }
}
