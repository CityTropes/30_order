package com.switchfully.eurder.services;

import com.switchfully.eurder.services.dtos.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO save(OrderDTO OrderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(String uuid);
}
