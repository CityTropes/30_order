package com.switchfully.eurder.services.validators;

import com.switchfully.eurder.domain.users.Address;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserValidatorTest {

    UserValidator testValidator = new UserValidator();

    @Test
    void test_validateEmail_UserValidator(){
        Address testAddress = new Address("teststreet", 10, 9000, "Gent");
        CreateUserDTO newUser = new CreateUserDTO("emailGuy", "theFirst", "first@fin.com", "0476987654","password",  testAddress);
        CreateUserDTO newUser2 = new CreateUserDTO("emailGuy2", "theSecond", "first.google.com.eu.edu", "0476987654","password",  testAddress);
        //regex doesn't check for 2 @'s
        Assertions.assertTrue(testValidator.validateEmail(newUser));
        Assertions.assertFalse(testValidator.validateEmail(newUser2));

    }

}