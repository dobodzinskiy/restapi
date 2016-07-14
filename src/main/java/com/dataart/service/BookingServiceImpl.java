package com.dataart.service;

import com.dataart.dao.BookingDaoImpl;
import com.dataart.dto.BookingDto;
import com.dataart.dto.ValidationErrorDto;
import com.dataart.entity.Booking;
import com.dataart.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
    public ResponseEntity<?> order(BookingDto bookingDto) {
        Booking booking = bookingMapper.fromDto(bookingDto);
        if (checkBookingDto(booking).getFieldErrors().isEmpty()) {
            booking.setRoom(roomService.lockRoom(bookingDto.getRoomId()));
            bookingDao.create(booking);
            return new ResponseEntity<>(bookingMapper.toDto(booking), HttpStatus.OK);
        }
        return new ResponseEntity<>(checkBookingDto(booking), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ValidationErrorDto checkBookingDto(Booking booking) {
        ValidationErrorDto validationErrorDto = new ValidationErrorDto(400);
        if (booking.getStart().after(booking.getEnd())) {
            validationErrorDto.addFieldError("start", "Period is incorrect, check your start and dates.");
        }
        if (booking.getStart().before(new Date(System.currentTimeMillis()))) {
            validationErrorDto.addFieldError("start", "Start period cannot be before today.");
        }
        return validationErrorDto;
    }
}
