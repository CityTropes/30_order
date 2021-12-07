package com.switchfully.eurder.services.dtos;

import com.switchfully.eurder.domain.orders.ItemGroup;

import java.util.List;
import java.util.UUID;

public class OrderDTO {

    private final UUID orderId;
    private final UUID userID;
    private final List<ItemGroup> itemGroups;

    public OrderDTO(UUID orderId, UUID userID, List<ItemGroup> itemGroups) {
        this.orderId = orderId;
        this.userID = userID;
        this.itemGroups = itemGroups;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getUserID() {
        return userID;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
