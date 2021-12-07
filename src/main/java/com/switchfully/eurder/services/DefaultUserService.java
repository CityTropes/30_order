package com.switchfully.eurder.services;

import com.switchfully.eurder.customexceptions.NotUniqueException;
import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import com.switchfully.eurder.services.mappers.UserConverter;
import com.switchfully.eurder.services.validators.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {

    private final UserConverter userConverter;
    private final DefaultUserRepository defaultUserRepository;
    private final UserValidator userValidator;

    public DefaultUserService(UserConverter userConverter, DefaultUserRepository defaultUserRepository, UserValidator userValidator) {
        this.userConverter = userConverter;
        this.defaultUserRepository = defaultUserRepository;
        this.userValidator = userValidator;
    }

    @Override
    public UserDTO save(CreateUserDTO createUserDTO) {
        if (userValidator.canUserBeSaved(createUserDTO, defaultUserRepository)) {
            User newUser = userConverter.convertCreateUserDtoToUser(createUserDTO);
            User savedUser = defaultUserRepository.save(newUser);                           //in 2 steps for clarity
            return userConverter.convertUserToUserDto(savedUser);
        }
        throw new NotUniqueException("User can't be saved! Given email is not unique, or email syntax is wrong: " + createUserDTO.getEmailAddress());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = defaultUserRepository.getAllUsers();
        return userList.stream()
                .map(userConverter::convertUserToUserDto)
                .collect(Collectors.toList());
    }

}
