package com.dataart.service;

import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.entity.Room;

import java.util.List;

public interface RoomService {

    List<RoomDto> findRooms(RoomRequestDto roomRequestDto);

    List<RoomDto> findRooms();

    Room lockRoom(int id);

    RoomDto findRoom(int id);

    RoomDto createRoom(RoomDto roomDto);
}
