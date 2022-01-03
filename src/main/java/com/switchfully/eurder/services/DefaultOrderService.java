package com.switchfully.eurder.services;

import com.switchfully.eurder.customexceptions.OrderDateException;
import com.switchfully.eurder.customexceptions.UnknownCustomerException;
import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.domain.orders.ItemGroup;
import com.switchfully.eurder.domain.orders.Order;
import com.switchfully.eurder.repositories.DefaultItemRepository;
import com.switchfully.eurder.repositories.ItemGroupRepository;
import com.switchfully.eurder.repositories.ItemRepository;
import com.switchfully.eurder.repositories.OrderRepository;
import com.switchfully.eurder.services.OrderService;
import com.switchfully.eurder.services.dtos.CreateItemGroupDTO;
import com.switchfully.eurder.services.dtos.ItemGroupDTO;
import com.switchfully.eurder.services.dtos.OrderDTO;
import com.switchfully.eurder.services.mappers.ItemGroupMapper;
import com.switchfully.eurder.services.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DefaultOrderService implements OrderService {


    private final ItemGroupMapper itemGroupMapper;
    private final OrderMapper orderMapper;
    private final ItemRepository defaultItemRepository;             //to check shipping date
    private final ItemGroupRepository itemGroupRepository;
    private final OrderRepository orderRepository;
    private final DefaultItemService defaultItemService;

    public DefaultOrderService(ItemGroupMapper itemGroupMapper, OrderMapper orderMapper,
                               ItemRepository defaultItemRepository, ItemGroupRepository itemGroupRepository,
                               OrderRepository orderRepository, DefaultItemService defaultItemService) {
        this.itemGroupMapper = itemGroupMapper;
        this.orderMapper = orderMapper;
        this.defaultItemRepository = defaultItemRepository;
        this.itemGroupRepository = itemGroupRepository;
        this.orderRepository = orderRepository;
        this.defaultItemService = defaultItemService;
    }

    //todo: order service calc

    public Item convertItemIdToItem(UUID itemId){
        return defaultItemRepository.getItemById(itemId);
    }

    public double calculateItemGroupPrice(ItemGroup itemGroup){
        UUID lookUp = itemGroup.getItemId();
        return itemGroup.getItemAmount() * convertItemIdToItem(lookUp).getItemPriceInEur();
    }

    public LocalDate calculateItemGroupShippingDate(ItemGroup itemGroup){
        int amountInItemGroup = itemGroup.getItemAmount();
        int amountInStock = defaultItemRepository.getItemById(itemGroup.getItemId()).getAmountInStock();
        if(amountInItemGroup <= amountInStock){
            return LocalDate.now().plusDays(1);
        }
        return LocalDate.now().plusWeeks(1);
    }

    public double calculateOrderTotalPrice(Order order){
        double price = 0;
        return order.getItemGroups().stream()
                .map(this::calculateItemGroupPrice)
                .reduce(price, Double::sum);
    }

    public LocalDate calculateOrderShippingDate(Order order){
        return order.getItemGroups().stream()
                .map(this::calculateItemGroupShippingDate)
                .max(Comparator.naturalOrder())
                .orElseThrow(OrderDateException::new);
    }


    @Override
    public ItemGroupDTO save(CreateItemGroupDTO createItemGroupDTO) {
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);
        newItemGroup.setShippingDate(calculateItemGroupShippingDate(newItemGroup));
        newItemGroup.setPriceInEur(calculateItemGroupPrice(newItemGroup));
        ItemGroup savedItemGroup = itemGroupRepository.save(newItemGroup);
        return itemGroupMapper.convertItemGroupToItemGroupDto(savedItemGroup);
    }

    /*

    public void updateItemGroupsPriceAndShippingDate(UUID userID){
        List<ItemGroup> myItemGroups = new ArrayList<>();
        myItemGroups = itemGroupRepository.getAllItemGroups().stream()
                .filter(x -> x.getUserId().equals(userID))
                .collect(Collectors.toList());
        myItemGroups.stream()
                .map(this::calculateItemGroupPrice)
                .collect(Collectors.toList());


        myItemGroups.stream()
                .map(this::calculateItemGroupShippingDate)
                .collect(Collectors.toList());

        for(ItemGroup itemGroup: myItemGroups){
            ItemGroup groupToUpdate = itemGroupRepository.getItemGroupById(itemGroup.getItemGroupId());
            groupToUpdate.setPriceInEur();
        }

    }

     */



    @Override
    public List<ItemGroupDTO> getAllMyItemGroups(UUID userId) {
        //todo: update shipping date and price ---> method update price&shippingdate
        return itemGroupRepository.getAllItemGroups().stream()
                .filter(x -> x.getUserId().equals(userId))
                .map(itemGroupMapper::convertItemGroupToItemGroupDto)
                .collect(Collectors.toList());
    }

    @Override
    //todo: replace param with createOrderDto
    public OrderDTO save(OrderDTO OrderDTO) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO getOrderById(String uuid) {
        return null;
    }
}
