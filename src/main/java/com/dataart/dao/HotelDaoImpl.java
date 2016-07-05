package com.dataart.dao;

import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Client;
import com.dataart.entity.Hotel;
import com.dataart.entity.Order;
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
public class HotelDaoImpl implements HotelDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelDaoImpl.class);
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> findRooms(RoomRequestDto roomRequestDto) {
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

    @Override
    public List<Room> findRooms() {
        TypedQuery<Room> roomTypedQuery = entityManager.createNamedQuery("Room.FindAllRooms", Room.class);
        List<Room> rooms;
        try {
            rooms = roomTypedQuery.getResultList();
        } catch (NoResultException ex) {
            LOGGER.warn("Applications weren't found", ex);
            return Collections.emptyList();
        }
        return rooms;
    }

    @Override
    public Room findRoom(int id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public Hotel findHotel(int id) {
        return entityManager.find(Hotel.class, id);
    }

    @Override
    public Order findOrder(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void saveClient(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void saveOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void updateRoom(Room room) {
        entityManager.merge(room);
    }
}
