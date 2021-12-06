package com.switchfully.eurder.services.mappers;

import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Role;
import com.switchfully.eurder.services.dtos.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    UserRepository testRepo = new DefaultUserRepository();
    UserConverter test = new UserConverter();
    UserDTO testDto = new UserDTO(testRepo.getUser("admin@eurder.com").getId(), "Default", "Admin", Role.ADMIN);
    User testAdmin = testRepo.getUser("admin@eurder.com");

    @Test
    void mapperConvertsToUserDto() {
        Assertions.assertEquals(testDto, test.convertUserToUserDto(testAdmin));
    }
}