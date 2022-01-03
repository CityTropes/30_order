package com.switchfully.eurder.services;

import com.switchfully.eurder.customexceptions.UnknownItemException;
import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.domain.orders.ItemGroup;
import com.switchfully.eurder.domain.orders.Order;
import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.DefaultItemGroupRepository;
import com.switchfully.eurder.repositories.DefaultItemRepository;
import com.switchfully.eurder.repositories.DefaultOrderRepository;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.services.dtos.CreateItemGroupDTO;
import com.switchfully.eurder.services.mappers.ItemGroupMapper;
import com.switchfully.eurder.services.mappers.ItemMapper;
import com.switchfully.eurder.services.mappers.OrderMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultOrderServiceTest {


    ItemGroupMapper itemGroupMapper = new ItemGroupMapper();
    OrderMapper orderMapper = new OrderMapper();
    ItemMapper itemMapper = new ItemMapper();
    DefaultItemRepository repo = new DefaultItemRepository();
    DefaultUserRepository repoUser = new DefaultUserRepository();
    DefaultItemGroupRepository repoItemGroup = new DefaultItemGroupRepository();
    DefaultOrderRepository repoOrder = new DefaultOrderRepository();
    User admin = repoUser.getUser("admin@eurder.com");
    Item item = repo.getItemByName("testItem");
    DefaultItemService itemService = new DefaultItemService(itemMapper,repo);
    DefaultOrderService testService = new DefaultOrderService(itemGroupMapper, orderMapper, repo, repoItemGroup, repoOrder, itemService);

    @Test
    void calculateItemGroupPrice_isCorrect(){
        repo.addItem();
        System.out.println(repo.getItemByName("testItem").getItemDescription());
        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 20);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);

        Assertions.assertEquals(10, testService.calculateItemGroupPrice(newItemGroup));
    }
/*
    @Test
    void calculateItemGroupShippingDate_returnsCorrectDate(){
        CreateItemGroupDTO testGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(),5);
        LocalDate ETA = testService.calculateItemGroupShippingDate(testGroupDTO);
        //ItemGroup testGroup = new ItemGroup(admin.getId(), item.getItemId(), 5);
        System.out.println(ETA);

        Assertions.assertEquals(ETA, LocalDate.now().plusDays(1));
    }

    @Test
    void calculateItemGroupShippingDate_returnsCorrectDate_noStock(){
        CreateItemGroupDTO testGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(),500);
        LocalDate ETA = testService.calculateItemGroupShippingDate(testGroupDTO);
        //ItemGroup testGroup = new ItemGroup(admin.getId(), item.getItemId(), 5);
        System.out.println(ETA);

        Assertions.assertEquals(ETA, LocalDate.now().plusWeeks(1));
    }

    @Test
    void calculateOrderTotalPrice_returnsCorrectPrice(){
        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 20);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);
        Order testOrder = new Order(admin.getId(), List.of(newItemGroup));

        System.out.println(testService.calculateOrderTotalPrice(testOrder));

        Assertions.assertEquals(10,testService.calculateOrderTotalPrice(testOrder));
    }

    @Test
    void calculateOrderTotalPrice_returnsCorrectPrice2(){
        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 20);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);
        Order testOrder = new Order(admin.getId(), List.of(newItemGroup, newItemGroup));

        Assertions.assertEquals(20,testService.calculateOrderTotalPrice(testOrder));
    }

    @Test
    void calculateOrderShippingDate_returnsCorrectDate_inStock(){

        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 20);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);
        Order testOrder = new Order(admin.getId(), List.of(newItemGroup, newItemGroup));

        LocalDate testDate = testService.calculateItemGroupShippingDate(createItemGroupDTO);
        System.out.println(testDate);
        LocalDate etaDate = testService.calculateOrderShippingDate(testOrder);
        System.out.println(etaDate);

        Assertions.assertEquals(testDate, etaDate);
    }



    @Test
    void calculateOrderShippingDate_returnsCorrectDate_notInStock(){

        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 200);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);
        Order testOrder = new Order(admin.getId(), List.of(newItemGroup, newItemGroup));

        LocalDate testDate = testService.calculateItemGroupShippingDate(createItemGroupDTO);
        System.out.println(testDate);
        LocalDate etaDate = testService.calculateOrderShippingDate(testOrder);
        System.out.println(etaDate);

        Assertions.assertEquals(testDate, etaDate);
    }

    @Test
    void calculateOrderShippingDate_returnsCorrectDate_itemNotInStock_itemStock(){

        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 5);
        CreateItemGroupDTO createItemGroupDTO2 = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 500);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);
        ItemGroup newItemGroup2 = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO2);
        Order testOrder = new Order(admin.getId(), List.of(newItemGroup, newItemGroup2));

        LocalDate testDate = testService.calculateItemGroupShippingDate(createItemGroupDTO);
        LocalDate testDate2 = testService.calculateItemGroupShippingDate(createItemGroupDTO2);
        System.out.println(testDate);
        System.out.println(testDate2);
        LocalDate etaDate = testService.calculateOrderShippingDate(testOrder);
        System.out.println(etaDate);

        Assertions.assertEquals(testDate2, etaDate);
    }


    //exception tests

    @Test
    void testNullException_WhenItemGroupIsEmpty(){
        CreateItemGroupDTO createItemGroupDTO = new CreateItemGroupDTO(admin.getId(), repo.getItemByName("testItem").getItemId(), 20);
        ItemGroup newItemGroup = itemGroupMapper.convertCreateItemGroupDtoToItemGroup(createItemGroupDTO);

        NullPointerException testException = assertThrows(NullPointerException.class, ()->new Order(admin.getId(), List.of(newItemGroup, null)));
    }
 */

    @Test
    void assertExceptionIsThrown_whenItemIsNotFound(){
        UnknownItemException testE = assertThrows(UnknownItemException.class, ()->repo.getItemByName("computerSaysNo"));

        Assertions.assertEquals(testE.getMessage(), "Item not found!");
    }

}