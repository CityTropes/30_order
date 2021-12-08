package com.switchfully.eurder.api;

import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.DefaultItemService;
import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.dtos.CreateItemDTO;
import com.switchfully.eurder.services.dtos.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "items", produces = "application/json")
public class ItemController {

    private final DefaultItemService defaultItemService;
    private final SecurityService securityService;

    public ItemController(DefaultItemService defaultItemService, SecurityService securityService) {
        this.defaultItemService = defaultItemService;
        this.securityService = securityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)                                          //only admin & registered users
    public List<ItemDTO> seeAllItems(@RequestHeader String authorization){
        securityService.validateAuthorization(authorization, Feature.SEE_ALL_ITEMS);
        return defaultItemService.getAllItems();
    }


    @PostMapping(path = "add-item", consumes = "application/json")      //only admin
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO saveItem(@RequestBody CreateItemDTO createItemDTO, @RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.ADD_NEW_ITEM);
        return defaultItemService.save(createItemDTO);
    }

}
