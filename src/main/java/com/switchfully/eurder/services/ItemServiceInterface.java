package com.switchfully.eurder.services;

import com.switchfully.eurder.services.dtos.CreateItemDTO;
import com.switchfully.eurder.services.dtos.ItemDTO;

import java.util.List;

public interface ItemServiceInterface {

    ItemDTO save(CreateItemDTO createItemDTO);
    List<ItemDTO> getAllItems();
}
