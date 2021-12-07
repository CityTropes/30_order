package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.orders.Order;
import com.switchfully.eurder.services.dtos.CreateOrderDTO;
import com.switchfully.eurder.services.dtos.OrderDTO;

public class OrderMapper {

    public Order convertCreateOrderDtoToItem(CreateOrderDTO createOrderDTO) {
        Order output = new Order(
                createOrderDTO.getUserID(), createOrderDTO.getItemGroups());
        return output;
    }

    public OrderDTO convertOrderToOrderDto(Order savedOrder) {
        return new OrderDTO(savedOrder.getOrderId(), savedOrder.getUserID(), savedOrder.getItemGroups(),
                savedOrder.getTotalPriceInEur());
    }
}
