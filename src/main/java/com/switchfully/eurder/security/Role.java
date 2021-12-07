package com.switchfully.eurder.security;

import java.util.List;

import static com.switchfully.eurder.security.Feature.*;

public enum Role {
    CUSTOMER(List.of(
            REGISTER_NEW_CUSTOMER)),
    ADMIN(List.of(
            SEE_ONE_CUSTOMER,
            SEE_ALL_CUSTOMERS,
            REGISTER_NEW_CUSTOMER,
            SEE_ALL_ITEMS,
            ADD_NEW_ITEM));

    private final List<Feature> listOfFeatures;

    Role(List<Feature> listFeatures) {
        listOfFeatures = listFeatures;
    }

    public List<Feature> getListOfFeatures() {
        return listOfFeatures;
    }
}
