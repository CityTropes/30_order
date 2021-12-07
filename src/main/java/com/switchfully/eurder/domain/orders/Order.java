package com.switchfully.eurder.domain.orders;

import java.util.List;
import java.util.UUID;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class Order {

    private final UUID orderId;
    private final UUID userID;
    private final List<ItemGroup> itemGroups;               // = new LinkedList<>(); //can queue or stack
    private double totalPriceInEur;

    public Order(UUID userID, List<ItemGroup> itemGroups) {
        assertAllParamsNotNull(userID, itemGroups);
        this.orderId = UUID.randomUUID();
        this.userID = userID;
        this.itemGroups = itemGroups;
        this.totalPriceInEur = calculateTotalPriceInEur(itemGroups);
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

    public double getTotalPriceInEur() {
        return totalPriceInEur;
    }

    public double calculateTotalPriceInEur(List<ItemGroup> itemGroups) {
        //todo: calculateTotalPrice in service?
        /*
        public int calculateTotalPriceOfOrder(List<ItemGroup> itemGroups) {
            int price = 0;
            int amount = 0;
            for (ItemGroup item : itemGroups) {
                Item itemInItemGroup = itemRepository.getItemById(item.getSelectedItemId());
                price = itemInItemGroup.getPrice();
                amount = item.getAmount();

            }
            return price * amount;
        }

         */
        return 0;
    }

}
