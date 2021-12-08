package com.switchfully.eurder.services.dtos;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class CreateItemDTO {
    private final String itemName;
    private final String itemDescription;
    private final double itemPriceInEur;
    private final int amountInStock;

    public CreateItemDTO(String itemName, String itemDescription, double itemPriceInEur, int amountInStock) {
        assertAllParamsNotNull(itemName, itemDescription, itemPriceInEur, amountInStock);
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPriceInEur = itemPriceInEur;
        this.amountInStock = amountInStock;
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
}
