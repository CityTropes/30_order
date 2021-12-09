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

    //todo: refactor: move security check to services

    //temporary: just for testing purposes -> ok
    @GetMapping(path = "/testbasiclink")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void nothing(){
        System.out.println("testbasiclink");
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(@RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.SEE_ALL_CUSTOMERS); //only admin can see all users overview
        return defaultUserService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable("id") String id, @RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Feature.SEE_ONE_CUSTOMER);     //only admin can see selected user details
        return defaultUserService.getUserById(id);
    }

    @PostMapping(consumes = "application/json")                             //check REST naming conventions
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerNewCustomer(@RequestBody CreateUserDTO createUserDTO) {
        return defaultUserService.save(createUserDTO);
    }

}
