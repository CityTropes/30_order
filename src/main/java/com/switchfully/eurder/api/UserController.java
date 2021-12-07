package com.switchfully.eurder.api;

import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.DefaultUserService;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {

    private final DefaultUserService defaultUserService;
    private final SecurityService securityService;

    @Autowired
    public UserController(DefaultUserService defaultUserService, SecurityService securityService) {
        this.defaultUserService = defaultUserService;
        this.securityService = securityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(@RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.SEE_ALL_CUSTOMERS); //just to check, only admin can see
        return defaultUserService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable("id") String id, @RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.SEE_ONE_CUSTOMER);
        return defaultUserService.getUserById(id);
    }


    @PostMapping(path = "/register", consumes = "application/json")         //check REST naming conventions
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerNewCustomer(@RequestBody CreateUserDTO createUserDTO) {
        return defaultUserService.save(createUserDTO);
        //no authorization for register new customer
    }


    //todo: some exceptions & edge cases!
}
