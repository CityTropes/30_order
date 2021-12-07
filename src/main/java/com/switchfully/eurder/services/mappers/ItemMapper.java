package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.services.dtos.CreateItemDTO;
import com.switchfully.eurder.services.dtos.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item convertCreateItemDtoToItem(CreateItemDTO createItemDTO) {
        Item output = new Item(
                createItemDTO.getItemName(), createItemDTO.getItemDescription(),
                createItemDTO.getItemPriceInEur(), createItemDTO.getAmountInStock());
        return output;
    }

    public ItemDTO convertItemToItemDto(Item savedItem) {
        return new ItemDTO(savedItem.getItemId(), savedItem.getItemName(), savedItem.getItemDescription(),
                savedItem.getItemPriceInEur(), savedItem.getAmountInStock());
    }
}
