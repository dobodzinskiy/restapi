package com.dataart.mapper;

import com.dataart.dto.RoomDto;
import com.dataart.entity.Room;
import com.dataart.enums.RoomType;
import com.dataart.enums.RoomView;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomDto> {

    @Override
    public Room fromDto(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setBalcony(roomDto.getBalcony());
        room.setConditioner(roomDto.getConditioner());
        room.setTv(roomDto.getTv());
        room.setFree(roomDto.getFree());
        room.setNumber(roomDto.getNumber());
        room.setRoomType(RoomType.getEnum(roomDto.getRoomType()));
        room.setRoomView(RoomView.getEnum(roomDto.getRoomView()));
        return room;
    }

    @Override
    public RoomDto toDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setNumber(room.getNumber());
        roomDto.setFree(room.getFree());
        roomDto.setTv(room.getTv());
        roomDto.setBalcony(room.getBalcony());
        roomDto.setConditioner(room.getConditioner());
        roomDto.setHotelName(room.getHotel().getName());
        roomDto.setRoomType(room.getRoomType().getValue());
        roomDto.setRoomView(room.getRoomView().getValue());

        return roomDto;
    }
}