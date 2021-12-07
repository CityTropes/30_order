package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.domain.users.User;

import java.util.List;
import java.util.UUID;

public interface ItemRepository {

    //todo: add save

    List<Item> getAllItems();
    Item getItemByName(String itemName);
    Item getItemById(UUID uuid);
}
