package com.dataart.controller;

import com.dataart.dto.HotelDto;
import com.dataart.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1.0/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<HotelDto> findHotels() {
        return hotelService.findHotels();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public HotelDto create(@RequestBody @Valid HotelDto hotelDto) {
        return hotelService.createHotel(hotelDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public HotelDto find(@PathVariable("id") int id) {
        return hotelService.findHotel(id);
    }
}
