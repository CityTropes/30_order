package com.switchfully.eurder.services.dtos;

import com.switchfully.eurder.domain.orders.ItemGroup;

import java.util.List;
import java.util.UUID;

public class OrderDTO {

    private final UUID orderId;
    private final UUID userID;
    private final List<ItemGroup> itemGroups;
    private final double totalPriceInEur;

    public OrderDTO(UUID orderId, UUID userID, List<ItemGroup> itemGroups, double totalPriceInEur) {
        this.orderId = orderId;
        this.userID = userID;
        this.itemGroups = itemGroups;
        this.totalPriceInEur = totalPriceInEur;
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

    public double getTotalPriceInEur() {
        return totalPriceInEur;
    }

}
