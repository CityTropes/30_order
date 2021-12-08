package com.switchfully.eurder.services.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateItemDTOTest {


    @Test
    void createItemViaDto_createsCorrectDto() {

        CreateItemDTO create = new CreateItemDTO("itemName", "description", 5.5, 25);

        Assertions.assertEquals("itemName", create.getItemName());
        Assertions.assertEquals("description", create.getItemDescription());
        Assertions.assertEquals(5.5, create.getItemPriceInEur());
        Assertions.assertEquals(25, create.getAmountInStock());
    }
}

