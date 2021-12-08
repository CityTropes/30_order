package com.switchfully.eurder.api;

import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.DefaultOrderService;
import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /* todo: order controller
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAllOrders(@RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.SEE_ALL_ORDERS); //only admin can see
        return defaultOrderService.getAllOrders();
    }
     */

    @PostMapping(path = "add-to-shopping-cart", consumes = "application/json")      //only admin
    @ResponseStatus(HttpStatus.CREATED)
    public ItemGroupDTO saveItem(@RequestBody CreateItemGroupDTO createItemGroupDTO, @RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.ADD_TO_SHOPPING_CART);
        return defaultOrderService.save(createItemGroupDTO);
        //todo
    }

    //todo: see my shopping cart & confirm/finalize orders






}
