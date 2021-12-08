package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.orders.ItemGroup;

import java.util.List;
import java.util.UUID;

public interface ItemGroupRepository {

    //ItemGroup getItemGroupById(String uuid);
    List<ItemGroup> getAllItemGroups();
    List<ItemGroup> getAllItemGroupsByCustomerId(UUID uuid);
    ItemGroup save(ItemGroup itemGroup);
}


