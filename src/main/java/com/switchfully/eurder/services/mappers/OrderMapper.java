package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.orders.Order;
import com.switchfully.eurder.services.dtos.CreateOrderDTO;
import com.switchfully.eurder.services.dtos.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order convertCreateOrderDtoToOrder(CreateOrderDTO createOrderDTO) {
        Order output = new Order(
                createOrderDTO.getUserID(), createOrderDTO.getItemGroups());
        return output;
    }

    public OrderDTO convertOrderToOrderDto(Order savedOrder) {
        return new OrderDTO(savedOrder.getOrderId(), savedOrder.getUserID(), savedOrder.getItemGroups(),
                savedOrder.getTotalPriceInEur());
    }
}
