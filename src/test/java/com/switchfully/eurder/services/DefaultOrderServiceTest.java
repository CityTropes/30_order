package com.switchfully.eurder.services;

import com.switchfully.eurder.customexceptions.UnknownItemException;
import com.switchfully.eurder.domain.items.Item;
import com.switchfully.eurder.domain.orders.ItemGroup;
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
    void assertExceptionIsThrown_whenItemIsNotFound(){
        UnknownItemException testE = assertThrows(UnknownItemException.class, ()->repo.getItemByName("computerSaysNo"));
        Assertions.assertEquals(testE.getMessage(), "Item not found!");
    }

}