package com.dataart.mapper;

import com.dataart.dto.OrderDto;
import com.dataart.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class OrderMapper implements Mapper<Order, OrderDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderMapper.class);

    @Override
    public Order fromDto(OrderDto orderDto) {
        Order order = new Order();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            order.setStart(formatter.parse(orderDto.getStart()));
            order.setEnd(formatter.parse(orderDto.getEnd()));
        } catch (ParseException e) {
            LOGGER.error("Cannot convert date");
        }

        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        orderDto.setId(order.getId());
        orderDto.setHotelName(order.getHotel().getName());
        orderDto.setHotelId(order.getHotel().getId());
        orderDto.setNumber(order.getRoom().getNumber());
        orderDto.setRoomId(order.getRoom().getId());
        orderDto.setClientName(order.getClient().getName());
        orderDto.setClientLastName(order.getClient().getLastName());
        orderDto.setClientPhone(order.getClient().getPhone());
        orderDto.setStart(formatter.format(order.getStart()));
        orderDto.setEnd(formatter.format(order.getEnd()));

        return orderDto;
    }
}
