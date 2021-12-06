package com.switchfully.eurder.api;

import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.UserService;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;

    @Autowired
    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers(@RequestHeader String authorization){
        //todo: securityService.validateAuthorization(authorization, Features.GET_ALL_USERS);
        return userService.getAllUsers();
    }

    @PostMapping(path = "/register", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewCustomer(@RequestBody CreateUserDTO createUserDTO){
        return userService.save(createUserDTO);
        //returns 403 Forbidden in postman? using auth key, check json input
    }


}
