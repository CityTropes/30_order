package com.switchfully.eurder.services.dtos;

import java.util.UUID;

public class ItemDTO {

    private final UUID itemId;
    private final String itemName;
    private final String itemDescription;
    private final double itemPriceInEur;
    private final int amountInStock;

    public ItemDTO(UUID itemId, String itemName, String itemDescription, double itemPriceInEur, int amountInStock) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPriceInEur = itemPriceInEur;
        this.amountInStock = amountInStock;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPriceInEur() {
        return itemPriceInEur;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    //optional: use builder
}
