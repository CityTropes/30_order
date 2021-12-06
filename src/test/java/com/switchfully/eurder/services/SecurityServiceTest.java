package com.switchfully.eurder.services;

import com.switchfully.eurder.repositories.DefaultUserRepository;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.security.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SecurityServiceTest {

    UserRepository testRepo = new DefaultUserRepository();
    SecurityService testSecService = new SecurityService(testRepo);

    @Test
    void canHaveAccessTo_givenRoleAndFeature(){
        Role testRole = Role.ADMIN;
        Feature testFeature = Feature.SEE_ALL_CUSTOMERS;
        Assertions.assertTrue(testSecService.canHaveAccessTo(testFeature,testRole));
    }

    @Test
    void doPasswordsMatch(){
        Assertions.assertTrue(testSecService.doesPasswordMatch("admin007", "admin007"));
        Assertions.assertFalse(testSecService.doesPasswordMatch("admin008", "admin009"));
    }

}