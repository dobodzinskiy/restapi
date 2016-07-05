package com.dataart.mapper;

import com.dataart.dto.HotelDto;
import com.dataart.entity.Hotel;
import com.dataart.enums.HotelType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Component("hotelMapper")
public class HotelMapper implements Mapper<Hotel, HotelDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelMapper.class);

    @Override
    public Hotel fromDto(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setHotelType(HotelType.getEnum(hotelDto.getHotelType()));
        hotel.setPool(hotelDto.getPool());
        hotel.setSlides(hotelDto.getSlides());
        hotel.setTennis(hotelDto.getTennis());
        hotel.setDates(hotelDto.getDates().stream().map(date -> {
            try {
                return formatter.parse(date);
            } catch (ParseException e) {
                LOGGER.error("Cannot convert date");
                return null;
            }
        }).collect(Collectors.toList()));

        return hotel;
    }

    @Override
    public HotelDto toDto(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setHotelType(hotel.getHotelType().getValue());
        hotelDto.setPool(hotel.getPool());
        hotelDto.setSlides(hotel.getSlides());
        hotelDto.setTennis(hotel.getTennis());
        hotelDto.setDates(hotel.getDates().stream().map(formatter::format).collect(Collectors.toList()));

        return hotelDto;
    }
}
