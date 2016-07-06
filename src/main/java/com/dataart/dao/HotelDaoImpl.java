package com.dataart.dao;

import com.dataart.entity.Hotel;
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
public class HotelDaoImpl implements Dao<Hotel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelDaoImpl.class);
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hotel> findAll() {
        TypedQuery<Hotel> typedQuery = entityManager.createNamedQuery("Hotel.findHotels", Hotel.class);
        List<Hotel> hotels;
        try {
            hotels = typedQuery.getResultList();
        } catch (NoResultException ex) {
            LOGGER.warn("Hotels weren't found", ex);
            return Collections.emptyList();
        }
        return hotels;
    }

    @Override
    public Hotel find(int id) {
        return entityManager.find(Hotel.class, id);
    }

    @Override
    public void create(Hotel hotel) {
        entityManager.persist(hotel);
    }

    @Override
    public void update(Hotel hotel) {
        entityManager.merge(hotel);
    }
}
