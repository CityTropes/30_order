package com.switchfully.eurder.repositories;

import com.switchfully.eurder.customexceptions.UnknownCustomerException;
import com.switchfully.eurder.domain.users.Address;
import com.switchfully.eurder.domain.users.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultUserRepository implements UserRepository {


    private final ConcurrentHashMap<UUID, User> usersById;

    public DefaultUserRepository() {
        usersById = new ConcurrentHashMap<>();
        addAdmin();
    }

    private void addAdmin() {
        Address adminAddress = new Address("Adminstreet", 1, 1000, "Brussels");
        User defaultAdmin = new User("Default", "Admin", "admin@eurder.com", adminAddress, "0476123456", "admin");
        defaultAdmin.promoteRoleToAdmin();
        usersById.put(defaultAdmin.getId(), defaultAdmin);
    }

    public User save(User user) {
        usersById.put(user.getId(), user);
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        //assert not empty?
        return new ArrayList<>(usersById.values());
    }

    @Override
    public User getUser(String email) {
        return usersById.values()
                .stream()
                .filter(user -> user.getEmailAddress().equals(email))
                .findFirst()
                .orElseThrow(UnknownCustomerException::new);
    }

    /*
    @Override
    public ConcurrentHashMap<UUID, User> getUserById() {
        return usersById;
    }

 */


}
