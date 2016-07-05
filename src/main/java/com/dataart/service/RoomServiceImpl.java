package com.dataart.service;

import com.dataart.dao.ClientDaoImpl;
import com.dataart.dao.RoomDaoImpl;
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
    private RoomDaoImpl roomDao;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    @Transactional(readOnly = true)
    public List<RoomDto> findRooms(RoomRequestDto roomRequestDto) {
        List<Room> rooms = roomDao.findFilteredRooms(roomRequestDto);
        if (rooms.isEmpty()) {
            return Collections.emptyList();
        }
        return rooms.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> findRooms() {
        List<Room> rooms = roomDao.findAll();
        if (rooms.isEmpty()) {
            return Collections.emptyList();
        }
        return rooms.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
    }

    @Override
    public Room lockRoom(int id) {
        Room room = roomDao.find(id);
        room.setFree(false);
        roomDao.update(room);
        return room;
    }

    @Override
    public RoomDto findRoom(int id) {
        return roomMapper.toDto(roomDao.find(id));
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        return roomMapper.toDto(roomDao.create(roomMapper.fromDto(roomDto)));
    }
}
