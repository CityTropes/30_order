package com.switchfully.eurder.repositories;

import com.switchfully.eurder.domain.users.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public interface UserRepository {
    //ConcurrentHashMap<UUID, User> getUserById();
    List<User> getAllUsers();
    User getUser(String username);
}
