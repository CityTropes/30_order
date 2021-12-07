package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.repositories.DefaultItemRepository;
import com.switchfully.eurder.services.dtos.CreateItemDTO;
import com.switchfully.eurder.services.dtos.ItemDTO;
import com.switchfully.eurder.services.mappers.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultItemService implements ItemService {

    private final ItemMapper itemMapper;
    private final DefaultItemRepository defaultItemRepository;

    public DefaultItemService(ItemMapper itemMapper, DefaultItemRepository defaultItemRepository) {
        this.itemMapper = itemMapper;
        this.defaultItemRepository = defaultItemRepository;
    }


    @Override
    public ItemDTO save(CreateItemDTO createItemDTO) {
        //todo: check if item can be saved (validator)?
        Item newItem = itemMapper.convertCreateItemDtoToItem(createItemDTO);
        Item savedItem = defaultItemRepository.save(newItem);
        return itemMapper.convertItemToItemDto(savedItem);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> itemList = defaultItemRepository.getAllItems();
        return itemList.stream()
                .map(itemMapper::convertItemToItemDto)
                .collect(Collectors.toList());
    }
}
