package com.dataart.controller;

import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1.0/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> findRooms() {
        return roomService.findRooms();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public RoomDto createRoom(@RequestBody @Valid RoomDto roomDto) {
        return roomService.createRoom(roomDto);
    }

    @RequestMapping(value = "/filtered", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> findRooms(@RequestBody RoomRequestDto roomRequestDto) {
        return roomService.findRooms(roomRequestDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RoomDto findRoom(@PathVariable("id") int id) {
        return roomService.findRoom(id);
    }

}
