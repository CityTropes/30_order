package com.switchfully.eurder.api;

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
    private final SecurityService securityService; //not implemented yet

    public ItemController(DefaultItemService defaultItemService, SecurityService securityService) {
        this.defaultItemService = defaultItemService;
        this.securityService = securityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDTO> getAllItems(@RequestHeader String authorization){
        //todo: securityService.validateAuthorization(authorization, Features.GET_ALL_ITEMS);
        return defaultItemService.getAllItems();
    }


    @PostMapping(path = "save-item", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO saveItem(@RequestBody CreateItemDTO createItemDTO
                            /*, @RequestHeader String authorization*/) { //not implemented yet
        //todo: implement validation in securityService
        return defaultItemService.save(createItemDTO);
    }

}
