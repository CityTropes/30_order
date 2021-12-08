package com.switchfully.eurder.services;

import com.switchfully.eurder.repositories.DefaultItemRepository;
import com.switchfully.eurder.services.dtos.CreateItemDTO;
import com.switchfully.eurder.services.mappers.ItemMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultItemServiceTest {

    DefaultItemRepository repo = new DefaultItemRepository();
    ItemMapper mapper = new ItemMapper();
    DefaultItemService testService = new DefaultItemService(mapper,repo);

    @Test
    void save_returnsItemDto(){
        CreateItemDTO test = new CreateItemDTO("testItem", "test description", 0.5, 45);

        assertEquals("testItem", test.getItemName());
        Assertions.assertEquals(test.getItemDescription(), "test description");
        Assertions.assertEquals(test.getItemPriceInEur(), 0.5);
        Assertions.assertEquals(test.getAmountInStock(), 45);
    }

}