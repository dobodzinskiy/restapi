package com.dataart.dao;

import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Room;
import com.dataart.enums.HotelType;
import com.dataart.enums.RoomType;
import com.dataart.enums.RoomView;
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
        TypedQuery<Room> roomTypedQuery = entityManager.createNamedQuery("Room.FindRooms", Room.class);
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
    public void create(Room room) {
        entityManager.persist(room);
    }

    @Override
    public void update(Room room) {
        entityManager.merge(room);
    }

    public List<Room> findFilteredRooms(RoomRequestDto roomRequestDto) {
        String query = "select r from Room r where r.free = true";
        if (roomRequestDto.getHotelType() != HotelType.ANY) {
            query += " and r.hotel.hotelType = '" + roomRequestDto.getHotelType() + "'";
        }
        if (roomRequestDto.getRoomType() != RoomType.ANY) {
            query += " and r.roomType = '" + roomRequestDto.getRoomType() + "'";
        }
        if (roomRequestDto.getRoomView() != RoomView.ANY) {
            query += " and r.roomView = '" + roomRequestDto.getRoomView() + "'";
        }
        if (!roomRequestDto.getTv().isEmpty()) {
            query += " and r.tv = '" + roomRequestDto.getTv() + "'";
        }
        if (!roomRequestDto.getBalcony().isEmpty()) {
            query += " and r.balcony = '" + roomRequestDto.getBalcony() + "'";
        }
        if (!roomRequestDto.getConditioner().isEmpty()) {
            query += " and r.conditioner = '" + roomRequestDto.getConditioner() + "'";
        }
        if (!roomRequestDto.getSlides().isEmpty()) {
            query += " and r.hotel.slides = '" + roomRequestDto.getSlides() + "'";
        }
        if (!roomRequestDto.getPool().isEmpty()) {
            query += " and r.hotel.pool = '" + roomRequestDto.getPool() + "'";
        }
        if (!roomRequestDto.getTennis().isEmpty()) {
            query += " and r.hotel.tennis = '" + roomRequestDto.getTennis() + "'";
        }
        TypedQuery<Room> typedQuery = entityManager.createQuery(query, Room.class);
        List<Room> rooms;
        try {
            rooms = typedQuery.getResultList();
        } catch (NoResultException ex) {
            LOGGER.warn("Applications weren't found", ex);
            return Collections.emptyList();
        }
        return rooms;
    }
}
