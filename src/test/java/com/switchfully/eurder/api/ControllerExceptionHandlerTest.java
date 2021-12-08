package com.switchfully.eurder.api;

import com.switchfully.eurder.customexceptions.InvalidInputException;
import com.switchfully.eurder.customexceptions.UnauthorizedException;
import com.switchfully.eurder.domain.users.Address;
import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.services.DefaultUserService;
import com.switchfully.eurder.services.SecurityService;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import com.switchfully.eurder.services.dtos.UserDTO;
import com.switchfully.eurder.services.mappers.UserMapper;
import com.switchfully.eurder.services.validators.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ControllerExceptionHandlerTest {

    ControllerExceptionHandler handler = new ControllerExceptionHandler();
    UserValidator userValidator = new UserValidator();
    DefaultUserRepository testRepository = new DefaultUserRepository();
    UserMapper userMapper = new UserMapper();
    DefaultUserService testDefaultUserService = new DefaultUserService(userMapper, testRepository, userValidator);
    SecurityService securityService = new SecurityService(testRepository);
    Address testAddress = new Address("teststreet", 10, 9000, "Gent");
    CreateUserDTO newUser = new CreateUserDTO("firstGuy", "Premier", "first@fin.com", "0476987654","password",  testAddress);
    UserDTO userToTest = testDefaultUserService.save(newUser);

    @BeforeEach
    void beforeEach() {
        testRepository = new DefaultUserRepository();
        this.userMapper = new UserMapper();
        testDefaultUserService = new DefaultUserService(userMapper, testRepository, userValidator);
    }

    @Test
    @DisplayName("User Service Test")
    void saveNewUser_createsAndSavesNewUser_viaDTO_noExceptions(){
        assertEquals(newUser.getFirstName(), userToTest.getFirsName());
        assertEquals(newUser.getLastName(), userToTest.getLastName());
        assertEquals(newUser.getRole(), userToTest.getRole());
        System.out.println(testRepository.getAllUsers());
    }

    @Test
    void doesControllerCatchExceptions_InvalidInput(){
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, ()->userValidator.assertNotNullOrEmpty(null));
        Assertions.assertEquals(invalidInputException.getMessage(), "The given input can't contain null or empty fields (in user and address)! ");
    }

    @Test
    void doesControllerCatchExceptions_UnauthorizedException(){
        UnauthorizedException unauthorizedException = assertThrows(UnauthorizedException.class, ()->securityService.validateAuthorization(null, Feature.ADD_NEW_ITEM));
        Assertions.assertEquals(unauthorizedException.getMessage(), "You are not authorized to access this info. ");
    }


}