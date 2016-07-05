package com.dataart.dao;

import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Client;
import com.dataart.entity.Hotel;
import com.dataart.entity.Order;
import com.dataart.entity.Room;

import java.util.List;


public interface HotelDao {

    List<Room> findRooms(RoomRequestDto roomRequestDto);

    List<Room> findRooms();

    Room findRoom(int id);

    Hotel findHotel(int id);

    Order findOrder(int id);

    void saveClient(Client client);

    void saveOrder(Order order);

    void updateRoom(Room room);
}
