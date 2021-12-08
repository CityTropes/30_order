package com.switchfully.eurder.security;

import java.util.List;

import static com.switchfully.eurder.security.Feature.*;

public enum Role {
    CUSTOMER(List.of(
            REGISTER_NEW_CUSTOMER,
            SEE_ALL_ITEMS,
            ADD_TO_SHOPPING_CART,
            SEE_MY_ITEMGROUPS,
            FINALIZE_ORDER)),
    ADMIN(List.of(
            SEE_ONE_CUSTOMER,
            SEE_ALL_CUSTOMERS,
            REGISTER_NEW_CUSTOMER,
            SEE_ALL_ITEMS,
            ADD_NEW_ITEM,
            ADD_TO_SHOPPING_CART,
            FINALIZE_ORDER,
            SEE_ALL_ORDERS,
            SEE_MY_ITEMGROUPS
            ));

    private final List<Feature> listOfFeatures;

    Role(List<Feature> listFeatures) {
        listOfFeatures = listFeatures;
    }

    public List<Feature> getListOfFeatures() {
        return listOfFeatures;
    }
}
