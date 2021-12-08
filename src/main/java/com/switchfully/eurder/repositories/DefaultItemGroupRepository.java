package com.switchfully.eurder.repositories;

import com.switchfully.eurder.customexceptions.UnknownCustomerException;
import com.switchfully.eurder.domain.orders.ItemGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class DefaultItemGroupRepository implements ItemGroupRepository {

    private final ConcurrentHashMap<UUID, ItemGroup> itemGroupsById;

    public DefaultItemGroupRepository() {
        this.itemGroupsById = new ConcurrentHashMap<>();
    }


    @Override
    public List<ItemGroup> getAllItemGroups() {
        return new ArrayList<>(itemGroupsById.values());
    }

    @Override
    public List<ItemGroup> getAllItemGroupsByCustomerId(UUID uuid) {
        return itemGroupsById.values().stream()
                .filter(itemGroup -> itemGroup.getUserId().toString().equals(uuid.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public ItemGroup save(ItemGroup itemGroup) {
        itemGroupsById.put(itemGroup.getItemGroupId(), itemGroup);
        return itemGroup;
    }
    //todo: implement tostring (to show shopping cart details) en calculateTotal (in service)
}
