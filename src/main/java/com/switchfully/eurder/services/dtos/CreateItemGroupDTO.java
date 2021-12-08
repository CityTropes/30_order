package com.switchfully.eurder.services.dtos;

import java.time.LocalDate;
import java.util.UUID;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class CreateItemGroupDTO {
    private final UUID userId;
    private final UUID itemId;
    private final int itemAmount;
    private final LocalDate shippingDate;

    public CreateItemGroupDTO(UUID userId, UUID itemId, int itemAmount, LocalDate shippingDate) {
        assertAllParamsNotNull(userId, itemId, itemAmount, shippingDate);
        this.userId = userId;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
        this.shippingDate = shippingDate;
    }

    public UUID getUserId() {
        return userId;
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
}
