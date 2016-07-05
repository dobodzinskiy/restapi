package com.dataart.service;

import com.dataart.dao.HotelDaoImpl;
import com.dataart.dto.HotelDto;
import com.dataart.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelDaoImpl hotelDao;

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public List<HotelDto> findHotels() {
        return hotelDao.findAll().stream().map(hotelMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public HotelDto findHotel(int id) {
        return hotelMapper.toDto(hotelDao.find(id));
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        return hotelMapper.toDto(hotelDao.create(hotelMapper.fromDto(hotelDto)));
    }
}
