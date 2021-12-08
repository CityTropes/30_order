package com.switchfully.eurder.services;

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
import java.util.List;
import java.util.UUID;

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

    public LocalDate calculateItemGroupShippingDate(CreateItemGroupDTO createItemGroupDTO){
        int amountInItemGroup = createItemGroupDTO.getItemAmount();
        int amountInStock = defaultItemRepository.getItemById(createItemGroupDTO.getItemId()).getAmountInStock();
        if(amountInItemGroup <= amountInStock){
            return LocalDate.now().plusDays(1);
        }
        return LocalDate.now().plusWeeks(1);
    }

    public double calculateOrderTotalPrice(Order order){
        return 0;
    }

    public LocalDate calculateOrderShippingDate(Order order){

        return LocalDate.now();
    }



    @Override
    //todo: assert not null and user id exists!
    public ItemGroup save(ItemGroupDTO itemGroupDTO) {
        return null;
    }

    @Override
    public List<ItemGroup> getAllItemGroups() {
        return null;
    }

    @Override
    public List<ItemGroup> getAllItemGroupsByCustomerId(UUID uuid) {
        return null;
    }

    @Override
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
