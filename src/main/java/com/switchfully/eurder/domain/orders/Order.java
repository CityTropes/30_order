package com.switchfully.eurder.domain.orders;

import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID orderId;
    private final UUID userID;
    private final List<ItemGroup> itemGroups;               // = new LinkedList<>(); //can queue or stack

    public Order(UUID userID, List<ItemGroup> itemGroups) {
        this.orderId = UUID.randomUUID();
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
