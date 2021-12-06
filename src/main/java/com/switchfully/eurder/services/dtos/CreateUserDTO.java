package com.switchfully.eurder.services.dtos;

import com.switchfully.eurder.domain.users.Address;
import com.switchfully.eurder.security.Role;

import java.util.UUID;

public class CreateUserDTO {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;            //email = login/username
    private final Address address;
    private final String phoneNumber;
    private final Role role;
    private final String password;

    //nullcheck?
    public CreateUserDTO(String firstName, String lastName, String emailAddress, Address address, String phoneNumber, Role role, String password) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
        /**
         * Created an extra private constructor, otherwise Postman can't read the JSON.
         */
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
