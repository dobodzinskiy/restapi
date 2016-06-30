package com.dataart.service;

import com.dataart.dto.OrderDto;
import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Client;
import com.dataart.entity.Room;

import java.util.List;

public interface RoomService {

    List<RoomDto> findRooms(RoomRequestDto roomRequestDto);

    OrderDto order(OrderDto orderDto);

    Client createClient(String name, String lastName, String phone);

    Room lockRoom(int id);
}
