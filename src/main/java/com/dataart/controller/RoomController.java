package com.dataart.controller;

import com.dataart.dto.OrderDto;
import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(name = "/rooms", method = RequestMethod.GET)
    public List<RoomDto> findRooms(@RequestBody RoomRequestDto roomRequestDto) {
        return roomService.findRooms(roomRequestDto);
    }

    @RequestMapping(name="/orders", method = RequestMethod.POST)
    public OrderDto order(@RequestBody OrderDto orderDto) {
        return roomService.order(orderDto);
    }
}
