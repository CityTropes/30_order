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
    private String message;

    public ItemGroupDTO(UUID userId, UUID itemGroupId, UUID itemId,
                        int itemAmount, LocalDate shippingDate, double priceInEur) {
        assertAllParamsNotNull(userId, itemGroupId, itemId, itemAmount, shippingDate, priceInEur);
        this.userId = userId;
        this.itemGroupId = itemGroupId;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
        this.shippingDate = shippingDate;
        this.priceInEur = priceInEur;
        this.message = "--> Your item selection has been added to your shopping cart. (id: " + itemGroupId +") " +
                "\n\tGo to */orders?checkout-selection=" + itemGroupId + " to order these items. " +
                "\n\tGo to */orders?checkout-all=" + userId + " (userId) to order all items in shopping cart.";
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

    public String getMessage() {
        return message;
    }
}
