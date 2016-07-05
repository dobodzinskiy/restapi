package com.dataart.controller;

import com.dataart.dto.OrderDto;
import com.dataart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1.0/orders/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public OrderDto findOrders(@RequestBody @Valid OrderDto orderDto) {
        return orderService.order(orderDto);
    }

}
