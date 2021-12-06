package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.domain.users.User;

import java.util.List;

public interface ItemRepository {
    List<Item> getAllItems();
    Item getItem(String itemName);
}
