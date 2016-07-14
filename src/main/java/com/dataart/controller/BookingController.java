package com.dataart.controller;

import com.dataart.dto.BookingDto;
import com.dataart.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1.0/orders")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postOrder(@RequestBody @Valid BookingDto bookingDto) {
        return bookingService.order(bookingDto);
    }
}
