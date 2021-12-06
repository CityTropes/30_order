package com.switchfully.eurder.api;

import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.UserService;
import com.switchfully.eurder.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<UserDTO> getAllUsers(/* @RequestHeader String authorization */){
        //todo: securityService.validateAuthorization(authorization, Features.GET_ALL_MEMBERS);
        return userService.getAllUsers();
    }


}
