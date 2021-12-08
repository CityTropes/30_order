package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.orders.ItemGroup;
import com.switchfully.eurder.services.dtos.CreateItemGroupDTO;
import com.switchfully.eurder.services.dtos.ItemGroupDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public ItemGroup convertCreateItemGroupDtoToItem(CreateItemGroupDTO createItemGroupDTO) {
        ItemGroup output = new ItemGroup(
                createItemGroupDTO.getUserId(), createItemGroupDTO.getItemId(),
                createItemGroupDTO.getItemAmount(), createItemGroupDTO.getShippingDate());
        return output;
    }

    public ItemGroupDTO convertItemGroupToItemGroupDto(ItemGroup savedItemGroup) {
        return new ItemGroupDTO(savedItemGroup.getUserId(), savedItemGroup.getItemGroupId(), savedItemGroup.getItemId(),
                savedItemGroup.getItemAmount(), savedItemGroup.getShippingDate());
    }
}
