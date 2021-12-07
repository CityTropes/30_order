package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.orders.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderById(String uuid);
    Order save(Order order);
}
