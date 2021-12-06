package com.switchfully.eurder.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DefaultUserRepositoryTest {
    private DefaultUserRepository testRepository;

    @BeforeEach
    void beforeEach() {
        testRepository = new DefaultUserRepository();
    }

    @Test
    void getAllUsers_alwaysReturnsAdmin() {
        Assertions.assertEquals(testRepository.getAllUsers().size(), 1);
    }

}