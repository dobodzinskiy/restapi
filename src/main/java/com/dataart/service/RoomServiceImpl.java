package com.dataart.service;

import com.dataart.dao.HotelDao;
import com.dataart.dto.OrderDto;
import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Client;
import com.dataart.entity.Order;
import com.dataart.entity.Room;
import com.dataart.mapper.OrderMapper;
import com.dataart.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(readOnly = true)
    public List<RoomDto> findRooms(RoomRequestDto roomRequestDto) {
        List<Room> rooms = hotelDao.findRooms(roomRequestDto);
        if (rooms.isEmpty()) {
            return Collections.emptyList();
        }
        return rooms.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> findRooms() {
        List<Room> rooms = hotelDao.findRooms();
        if (rooms.isEmpty()) {
            return Collections.emptyList();
        }
        return rooms.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
    }

    @Override
    public Client createClient(String name, String lastName, String phone) {
        Client client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setPhone(phone);
        hotelDao.saveClient(client);

        return client;
    }

    @Override
    public Room lockRoom(int id) {
        Room room = hotelDao.findRoom(id);
        room.setFree(false);
        hotelDao.updateRoom(room);
        return room;
    }

    @Override
    public OrderDto order(OrderDto orderDto) {
        Order order = orderMapper.fromDto(orderDto);
        order.setClient(this.createClient(
                orderDto.getClientName(),
                orderDto.getClientLastName(),
                orderDto.getClientPhone()));
        order.setHotel(hotelDao.findHotel(orderDto.getHotelId()));
        order.setRoom(this.lockRoom(orderDto.getRoomId()));
        hotelDao.saveOrder(order);
        return orderMapper.toDto(order);
    }

    @Override
    public RoomDto findRoom(int id) {
        return roomMapper.toDto(hotelDao.findRoom(id));
    }
}
