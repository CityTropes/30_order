package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.orders.ItemGroup;

import java.util.List;

public interface ItemGroupRepository {

    //ItemGroup getItemGroupById(String uuid);
    List<ItemGroup> getAllItemGroups();
    List<ItemGroup> getAllItemGroupsByCustomerId();
    ItemGroup save(ItemGroup itemGroup);
}


