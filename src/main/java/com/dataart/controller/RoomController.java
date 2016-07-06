package com.dataart.controller;

import com.dataart.dto.RoomDto;
import com.dataart.dto.RoomRequestDto;
import com.dataart.enums.HotelType;
import com.dataart.enums.RoomType;
import com.dataart.enums.RoomView;
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RoomDto> findRooms(
            @RequestParam(required = false, defaultValue = "ANY", value = "hType") String hotelType,
            @RequestParam(required = false, defaultValue = "ANY", value = "rType") String roomType,
            @RequestParam(required = false, defaultValue = "ANY", value = "rView") String roomView,
            @RequestParam(required = false, defaultValue = "", value = "tv") String tv,
            @RequestParam(required = false, defaultValue = "", value = "c") String conditioner,
            @RequestParam(required = false, defaultValue = "", value = "b") String balcony,
            @RequestParam(required = false, defaultValue = "", value = "p") String pool,
            @RequestParam(required = false, defaultValue = "", value = "s") String slides,
            @RequestParam(required = false, defaultValue = "", value = "t") String tennis) {
        RoomRequestDto roomRequestDto =
                new RoomRequestDto(
                        HotelType.getEnum(hotelType),
                        RoomType.getEnum(roomType),
                        RoomView.getEnum(roomView),
                        tv, conditioner, balcony, pool, slides, tennis);
        return roomService.findRooms(roomRequestDto);
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
