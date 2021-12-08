package com.switchfully.eurder.repositories;

import com.switchfully.eurder.customexceptions.UnknownItemException;
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
        addItem();
    }

    public Item save(Item item) {
        itemsById.put(item.getItemId(), item);
        return item;
    }

    public void addItem() {
        Item testItem = new Item("testItem", "testDescription", 0.5, 60);
        itemsById.put(testItem.getItemId(), testItem);
    }


    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(itemsById.values());
    }

    @Override
    public Item getItemByName(String itemName) {
            return itemsById.values()
                    .stream()
                    .filter(item -> item.getItemName().equals(itemName))
                    .findFirst()
                    .orElseThrow(UnknownItemException::new);
    }

    @Override
    public Item getItemById(UUID uuid) {
        return itemsById.values().stream()
                .filter(item -> item.getItemId().toString().equals(uuid.toString()))
                .findFirst()
                .orElseThrow(UnknownItemException::new);
    }
}
