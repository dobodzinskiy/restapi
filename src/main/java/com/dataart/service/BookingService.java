package com.dataart.service;

import com.dataart.dto.BookingDto;
import com.dataart.dto.ValidationErrorDto;
import com.dataart.entity.Booking;
import org.springframework.http.ResponseEntity;

public interface BookingService {

    ResponseEntity<?> order(BookingDto bookingDto);

    ValidationErrorDto checkBookingDto(Booking booking);

}
