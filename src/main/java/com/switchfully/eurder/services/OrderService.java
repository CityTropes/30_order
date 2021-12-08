package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.orders.ItemGroup;
import com.switchfully.eurder.services.dtos.ItemGroupDTO;
import com.switchfully.eurder.services.dtos.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    List<ItemGroup> getAllItemGroups();
    List<ItemGroup> getAllItemGroupsByCustomerId(UUID uuid);
    ItemGroup save(ItemGroupDTO itemGroupDTO);                      //itemgroup = shopping cart

    OrderDTO save(OrderDTO OrderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(String uuid);
}
