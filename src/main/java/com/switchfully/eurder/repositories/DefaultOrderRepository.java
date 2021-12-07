package com.switchfully.eurder.repositories;

import com.switchfully.eurder.customexceptions.UnknownCustomerException;
import com.switchfully.eurder.domain.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultOrderRepository implements OrderRepository {

    private final ConcurrentHashMap<UUID, Order> ordersById;

    public DefaultOrderRepository() {
        this.ordersById = new ConcurrentHashMap<>();
    }


    @Override
    public Order save(Order order) {
        ordersById.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(ordersById.values());
    }

    @Override
    public Order getOrderById(String uuid) {
        return ordersById.values()
                .stream()
                .filter(order -> order.getOrderId().toString().equals(uuid))
                .findFirst()
                .orElseThrow(UnknownCustomerException::new);
    }
}
