package com.dataart.dao;

import com.dataart.entity.Order;
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
public class OrderDaoImpl implements Dao<Order> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> typedQuery = entityManager.createNamedQuery("Order.findOrders", Order.class);
        List<Order> orders;
        try {
            orders = typedQuery.getResultList();
        } catch(NoResultException ex) {
            LOGGER.warn("Orders weren't found", ex);
            return Collections.emptyList();
        }
        return orders;
    }

    @Override
    public Order find(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void create(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }
}
