package com.switchfully.eurder.services;

import com.switchfully.eurder.domain.users.Address;
import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.security.Role;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private DefaultUserRepository testRepository;
    private UserService testUserService;
    private UserConverter userConverter;

    @BeforeEach
    void beforeEach() {
        testRepository = new DefaultUserRepository();
        this.userConverter = new UserConverter();
        testUserService = new UserService(userConverter, testRepository);

    }

    @Test
    @DisplayName("User Service Test")
    void saveNewUser_createsAndSavesNewUser_viaDTO(){
        Address testAddress = new Address("teststreet", 10, 9000, "Gent");
        CreateUserDTO newUser = new CreateUserDTO("firstGuy", "Premier", "first@fin.com", "0476987654","password",  testAddress);
        UserDTO userToTest = testUserService.save(newUser);

        assertEquals(newUser.getFirstName(), userToTest.getFirsName());
        assertEquals(newUser.getLastName(), userToTest.getLastName());
        assertEquals(newUser.getRole(), userToTest.getRole());
        System.out.println(testRepository.getAllUsers());
    }

}