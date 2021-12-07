package com.switchfully.eurder.domain.items;

import java.util.Objects;
import java.util.UUID;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class Item {

    //todo: check if newly added item doesn't exist already

    private final UUID itemId;
    private String itemName;
    private String itemDescription;
    private double itemPriceInEur;      //make class Price
    private int amountInStock;

    public Item(String itemName, String itemDescription, double itemPriceInEur, int amountInStock) {
        assertAllParamsNotNull(itemName, itemDescription, itemPriceInEur, amountInStock);
        this.itemId = UUID.randomUUID();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId.equals(item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }
}
