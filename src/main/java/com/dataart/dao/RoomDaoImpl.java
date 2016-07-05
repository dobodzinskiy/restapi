package com.dataart.dao;

import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Room;
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
public class RoomDaoImpl implements Dao<Room> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> findAll() {
        TypedQuery<Room> roomTypedQuery = entityManager.createNamedQuery("Room.FindAllRooms", Room.class);
        List<Room> rooms;
        try {
            rooms = roomTypedQuery.getResultList();
        } catch (NoResultException ex) {
            LOGGER.warn("Rooms weren't found", ex);
            return Collections.emptyList();
        }
        return rooms;
    }

    @Override
    public Room find(int id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public Room create(Room room) {
        entityManager.persist(room);
        return room;
    }

    @Override
    public Room update(Room room) {
        entityManager.merge(room);
        return room;
    }

    public List<Room> findFilteredRooms(RoomRequestDto roomRequestDto) {
        TypedQuery<Room> roomTypedQuery = entityManager.createNamedQuery("Room.FindRooms", Room.class);
        List<Room> rooms;
        roomTypedQuery.setParameter("hotelType", roomRequestDto.getHotelType());
        roomTypedQuery.setParameter("roomView", roomRequestDto.getRoomView());
        roomTypedQuery.setParameter("roomView", roomRequestDto.getRoomView());
        roomTypedQuery.setParameter("tv", roomRequestDto.getTv());
        roomTypedQuery.setParameter("balcony", roomRequestDto.getBalcony());
        roomTypedQuery.setParameter("conditioner", roomRequestDto.getConditioner());
        roomTypedQuery.setParameter("pool", roomRequestDto.getPool());
        roomTypedQuery.setParameter("slides", roomRequestDto.getSlides());
        roomTypedQuery.setParameter("tennis", roomRequestDto.getTennis());
        try {
            rooms = roomTypedQuery.getResultList();
        } catch (NoResultException ex) {
            LOGGER.warn("Applications weren't found", ex);
            return Collections.emptyList();
        }
        return rooms;
    }
}
