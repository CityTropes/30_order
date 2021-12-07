package com.switchfully.eurder.services;

import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.services.mappers.UserMapper;
import com.switchfully.eurder.services.validators.UserValidator;
import org.junit.jupiter.api.BeforeEach;

class DefaultUserServiceTest {

    private DefaultUserRepository testRepository;
    private DefaultUserService testDefaultUserService;
    private UserMapper userMapper;
    private UserValidator userValidator;

    @BeforeEach
    void beforeEach() {
        testRepository = new DefaultUserRepository();
        this.userMapper = new UserMapper();
        testDefaultUserService = new DefaultUserService(userMapper, testRepository, userValidator);
        this.userValidator = new UserValidator();

    }

    /*
    @Test
    @DisplayName("User Service Test")
    void saveNewUser_createsAndSavesNewUser_viaDTO(){
        Address testAddress = new Address("teststreet", 10, 9000, "Gent");
        CreateUserDTO newUser = new CreateUserDTO("firstGuy", "Premier", "first@fin.com", "0476987654","password",  testAddress);
        UserDTO userToTest = testDefaultUserService.save(newUser);

        assertEquals(newUser.getFirstName(), userToTest.getFirsName());
        assertEquals(newUser.getLastName(), userToTest.getLastName());
        assertEquals(newUser.getRole(), userToTest.getRole());
        System.out.println(testRepository.getAllUsers());
    }

     */

}