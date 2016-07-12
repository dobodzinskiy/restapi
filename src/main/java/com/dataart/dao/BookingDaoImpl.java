package com.dataart.dao;

import com.dataart.entity.Booking;
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
public class BookingDaoImpl implements Dao<Booking> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Booking> findAll() {
        TypedQuery<Booking> typedQuery = entityManager.createNamedQuery("Order.findOrders", Booking.class);
        List<Booking> bookings;
        try {
            bookings = typedQuery.getResultList();
        } catch(NoResultException ex) {
            LOGGER.warn("Orders weren't found", ex);
            return Collections.emptyList();
        }
        return bookings;
    }

    @Override
    public Booking find(int id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public void create(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    public void update(Booking booking) {
        entityManager.merge(booking);
    }
}
