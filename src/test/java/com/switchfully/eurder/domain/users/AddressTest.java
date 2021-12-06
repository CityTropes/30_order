package com.switchfully.eurder.domain.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    @DisplayName("Basic Address Test")
    void whenCreatingAddress_correctAddressIsCreated(){
        Address testAddress = new Address("SwitchfullyStreet", 42, 1000, "Brussels");
        Assertions.assertEquals("Brussels", testAddress.getCity());
        Assertions.assertEquals(testAddress.getStreetName(),"SwitchfullyStreet");
        Assertions.assertEquals(testAddress.getStreetNumber(),42);
        Assertions.assertEquals(testAddress.getPostalCode(), 1000);
    }
}