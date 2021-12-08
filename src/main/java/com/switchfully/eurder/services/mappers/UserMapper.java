package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertCreateUserDtoToUser(CreateUserDTO createUserDTO){
        User output = new User(
                createUserDTO.getFirstName(), createUserDTO.getLastName(),
                createUserDTO.getEmailAddress(), createUserDTO.getAddress(),
                createUserDTO.getPhoneNumber(), createUserDTO.getPassword());
        return output;
    }

    public UserDTO convertUserToUserDto(User savedUser){
        return new UserDTO(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getRole());
    }

}
