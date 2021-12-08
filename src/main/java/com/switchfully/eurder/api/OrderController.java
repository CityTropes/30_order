package com.switchfully.eurder.api;

import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.DefaultOrderService;
import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "orders", produces = "application/json")
public class OrderController {

    private final DefaultOrderService defaultOrderService;
    private final SecurityService securityService;

    @Autowired
    public OrderController(DefaultOrderService defaultOrderService, SecurityService securityService) {
        this.defaultOrderService = defaultOrderService;
        this.securityService = securityService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> seeAllOrders(@RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.SEE_ALL_ORDERS);
        return defaultOrderService.getAllOrders();
    }

    @GetMapping(path = "/{userId}")                 //userId/shoppingcart
    @ResponseStatus(HttpStatus.OK)//seemyitemgroups
    public List<ItemGroupDTO> seeMySavedItemGroups(@PathVariable("userId") UUID userId,
                                                   @RequestHeader String authorization){
        securityService.validateAuthorization(authorization, Feature.SEE_MY_ITEMGROUPS);
        return defaultOrderService.getAllMyItemGroups(userId);
    }


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemGroupDTO saveItemsToShoppingCart(@RequestBody CreateItemGroupDTO createItemGroupDTO, @RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.ADD_TO_SHOPPING_CART);
        return defaultOrderService.save(createItemGroupDTO);
    }



    //todo: see my shopping cart & confirm/finalize orders, see all






}
