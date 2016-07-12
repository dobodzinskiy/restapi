package com.dataart.mapper;

import com.dataart.dto.BookingDto;
import com.dataart.entity.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component("orderMapper")
public class BookingMapper implements Mapper<Booking, BookingDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingMapper.class);

    @Override
    public Booking fromDto(BookingDto bookingDto) {
        Booking booking = new Booking();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            booking.setStart(formatter.parse(bookingDto.getStart()));
            booking.setEnd(formatter.parse(bookingDto.getEnd()));
        } catch (ParseException e) {
            LOGGER.error("Cannot convert date");
        }
        booking.setName(bookingDto.getClientName());
        booking.setLastName(bookingDto.getClientLastName());
        booking.setPhone(bookingDto.getClientPhone());

        return booking;
    }

    @Override
    public BookingDto toDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        bookingDto.setId(booking.getId());
        bookingDto.setHotelName(booking.getRoom().getHotel().getName());
        bookingDto.setNumber(booking.getRoom().getNumber());
        bookingDto.setRoomId(booking.getRoom().getId());
        bookingDto.setClientName(booking.getName());
        bookingDto.setClientLastName(booking.getLastName());
        bookingDto.setClientPhone(booking.getPhone());
        bookingDto.setStart(formatter.format(booking.getStart()));
        bookingDto.setEnd(formatter.format(booking.getEnd()));

        return bookingDto;
    }
}
