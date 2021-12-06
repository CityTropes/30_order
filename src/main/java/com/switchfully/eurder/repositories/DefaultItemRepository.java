package com.switchfully.eurder.repositories;
import com.switchfully.eurder.domain.items.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultItemRepository implements ItemRepository{

    private final ConcurrentHashMap<UUID, Item> itemsById;

    public DefaultItemRepository() {
        this.itemsById = new ConcurrentHashMap<>();
    }

    public Item save(Item item) {
        itemsById.put(item.getItemId(), item);
        return item;
    }


    @Override
    public List<Item> getAllItems() {
        //assert not empty
        return new ArrayList<>(itemsById.values());
    }

    @Override
    public Item getItem(String itemName) {
        //todo
        return null;
    }
}
