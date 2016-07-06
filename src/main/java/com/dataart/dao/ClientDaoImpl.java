package com.dataart.dao;

import com.dataart.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class ClientDaoImpl implements Dao<Client> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> typedQuery = entityManager.createNamedQuery("Client.findClients", Client.class);
        List<Client> clients;
        try {
            clients = typedQuery.getResultList();
        } catch (NoResultException ex) {
            LOGGER.warn("Clients weren't found", ex);
            return Collections.emptyList();
        }
        return clients;
    }

    @Override
    public Client find(int id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public void create(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void update(Client client) {
        entityManager.merge(client);
    }
}
