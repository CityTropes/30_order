package com.switchfully.eurder.services;

import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;

import java.util.List;

public interface UserServiceInterface {

    UserDTO save(CreateUserDTO createUserDTO);
    List<UserDTO> getAllUsers();
}
