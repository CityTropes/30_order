package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.orders.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderById(String uuid);
    Order save(Order order);
}
