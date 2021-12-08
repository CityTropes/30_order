package com.switchfully.eurder.services.dtos;

import java.time.LocalDate;
import java.util.UUID;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class CreateItemGroupDTO {
    private final UUID userId;
    private final UUID itemId;
    private final int itemAmount;

    public CreateItemGroupDTO(UUID userId, UUID itemId, int itemAmount) {
        assertAllParamsNotNull(userId, itemId, itemAmount);
        this.userId = userId;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
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
}
