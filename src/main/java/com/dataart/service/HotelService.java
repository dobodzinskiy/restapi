package com.dataart.service;

import com.dataart.dto.HotelDto;

import java.util.List;

public interface HotelService {

    List<HotelDto> findHotels();

    HotelDto findHotel(int id);

    HotelDto createHotel(HotelDto hotelDto);
}
