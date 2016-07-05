package com.dataart.service;

import com.dataart.dao.HotelDaoImpl;
import com.dataart.dao.OrderDaoImpl;
import com.dataart.dto.OrderDto;
import com.dataart.entity.Order;
import com.dataart.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private OrderDaoImpl orderDao;

    @Autowired
    private HotelDaoImpl hotelDao;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderDto order(OrderDto orderDto) {
        Order order = orderMapper.fromDto(orderDto);
        order.setClient(clientService.create(
                orderDto.getClientName(),
                orderDto.getClientLastName(),
                orderDto.getClientPhone()));
        order.setHotel(hotelDao.find(orderDto.getHotelId()));
        order.setRoom(roomService.lockRoom(orderDto.getRoomId()));
        orderDao.create(order);
        return orderMapper.toDto(order);
    }
}
