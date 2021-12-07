package com.switchfully.eurder.domain.orders;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final UUID itemGroupId;
    private final UUID itemId;
    private final int itemAmount;
    private final LocalDate shippingDate;

    public ItemGroup(UUID itemId, int itemAmount, LocalDate shippingDate) {
        this.itemId = itemId;
        this.itemAmount = itemAmount;
        this.shippingDate = shippingDate;
        this.itemGroupId = UUID.randomUUID();
        //todo: check availability in stock to determine shippingDate
    }

    public UUID getItemGroupId() { return itemGroupId; }

    public UUID getItemId() { return itemId; }

    public int getItemAmount() {
        return itemAmount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
