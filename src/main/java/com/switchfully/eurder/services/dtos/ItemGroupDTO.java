package com.switchfully.eurder.services.dtos;

import java.time.LocalDate;
import java.util.UUID;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class ItemGroupDTO {                     //itemGroup = element of shopping cart

    private final UUID userId;
    private final UUID itemGroupId;
    private final UUID itemId;
    private final int itemAmount;
    private LocalDate shippingDate;
    private double priceInEur;

    public ItemGroupDTO(UUID userId, UUID itemGroupId, UUID itemId,
                        int itemAmount, LocalDate shippingDate, double priceInEur) {
        assertAllParamsNotNull(userId, itemGroupId, itemId, itemAmount, shippingDate, priceInEur);
        this.userId = userId;
        this.itemGroupId = itemGroupId;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
        this.shippingDate = shippingDate;
        this.priceInEur = priceInEur;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getItemGroupId() {
        return itemGroupId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public double getPriceInEur() {
        return priceInEur;
    }
}
