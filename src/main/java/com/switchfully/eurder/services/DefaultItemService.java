package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.repositories.DefaultItemRepository;
import com.switchfully.eurder.services.dtos.CreateItemDTO;
import com.switchfully.eurder.services.dtos.ItemDTO;
import com.switchfully.eurder.services.mappers.ItemConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultItemService implements ItemService {

    private final ItemConverter itemConverter;
    private final DefaultItemRepository defaultItemRepository;

    public DefaultItemService(ItemConverter itemConverter, DefaultItemRepository defaultItemRepository) {
        this.itemConverter = itemConverter;
        this.defaultItemRepository = defaultItemRepository;
    }


    @Override
    public ItemDTO save(CreateItemDTO createItemDTO) {
        //todo: check if item can be saved (validator)
        Item newItem = itemConverter.convertCreateItemDtoToItem(createItemDTO);
        Item savedItem = defaultItemRepository.save(newItem);
        return itemConverter.convertItemToItemDto(savedItem);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> itemList = defaultItemRepository.getAllItems();
        return itemList.stream()
                .map(itemConverter::convertItemToItemDto)
                .collect(Collectors.toList());
    }
}
