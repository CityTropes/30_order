package com.switchfully.eurder.services.dtos;

import com.switchfully.eurder.domain.orders.ItemGroup;

import java.util.List;
import java.util.UUID;

public class CreateOrderDTO {

    private final UUID userID;
    private final List<ItemGroup> itemGroups;

    public CreateOrderDTO(UUID userID, List<ItemGroup> itemGroups) {
        this.userID = userID;
        this.itemGroups = itemGroups;
    }

    public UUID getUserID() {
        return userID;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
