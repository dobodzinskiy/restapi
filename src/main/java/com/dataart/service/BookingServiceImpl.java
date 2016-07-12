package com.dataart.service;

import com.dataart.dao.BookingDaoImpl;
import com.dataart.dto.BookingDto;
import com.dataart.entity.Booking;
import com.dataart.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDaoImpl bookingDao;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public BookingDto order(BookingDto bookingDto) {
        Booking booking = bookingMapper.fromDto(bookingDto);
        booking.setRoom(roomService.lockRoom(bookingDto.getRoomId()));
        bookingDao.create(booking);

        return bookingMapper.toDto(booking);
    }
}
