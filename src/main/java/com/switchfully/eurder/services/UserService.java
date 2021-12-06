package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import com.switchfully.eurder.services.mappers.UserConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    private final UserConverter userConverter;
    private final DefaultUserRepository defaultUserRepository;
    //private final UserValidator userValidator;

    public UserService(UserConverter userConverter, DefaultUserRepository defaultUserRepository) {
        this.userConverter = userConverter;
        this.defaultUserRepository = defaultUserRepository;
    }

    @Override
    public UserDTO save(CreateUserDTO createUserDTO) {
        //todo: check if user can be saved (validator)
        User newUser = userConverter.convertCreateUserDtoToUser(createUserDTO);
        User savedUser = defaultUserRepository.save(newUser);                           //in 2 steps for clarity
        return userConverter.convertUserToUserDto(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = defaultUserRepository.getAllUsers();
        return userList.stream()
                .map(userConverter::convertUserToUserDto)
                .collect(Collectors.toList());
    }

}
