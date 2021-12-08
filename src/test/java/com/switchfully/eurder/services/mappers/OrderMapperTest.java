package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.orders.ItemGroup;
import com.switchfully.eurder.domain.orders.Order;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.services.dtos.CreateOrderDTO;
import com.switchfully.eurder.services.dtos.OrderDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.UUID;

class OrderMapperTest {

    DefaultUserRepository test = new DefaultUserRepository();
    OrderMapper mapper = new OrderMapper();

    @Test
    void convertCreateOrderDtoToOrder(){

        CreateOrderDTO createOrderDTO = new CreateOrderDTO(test.getUser("admin@eurder.com").getId(),
                new LinkedList<>());

        Order newOrder = mapper.convertCreateOrderDtoToOrder(createOrderDTO);

        Assertions.assertEquals(newOrder.getUserID(),test.getUser("admin@eurder.com").getId());
        Assertions.assertEquals(newOrder.getItemGroups(), new LinkedList<ItemGroup>());
    }

}