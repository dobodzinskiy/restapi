package com.dataart.controller;

import com.dataart.dto.OrderDto;
import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1.0/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> findRooms(@RequestBody RoomRequestDto roomRequestDto, @RequestParam("filter") String filter) {
        return roomService.findRooms(roomRequestDto);
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> findRooms() {
        return roomService.findRooms();
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RoomDto findRoom(@PathVariable("id") int id) {
        return roomService.findRoom(id);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public OrderDto order(@RequestBody @Valid OrderDto orderDto) {
        return roomService.order(orderDto);
    }
}
