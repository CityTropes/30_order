package com.switchfully.eurder.services.dtos;

import com.switchfully.eurder.domain.users.Address;
import com.switchfully.eurder.security.Role;

import java.util.UUID;

import static com.switchfully.eurder.services.validators.AssertNotNull.assertAllParamsNotNull;

public class CreateUserDTO {

    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;            //email = login/username
    private final Address address;
    private final String phoneNumber;
    private final Role role;
    private final String password;

    public CreateUserDTO(String firstName, String lastName, String emailAddress, String phoneNumber, String password, Address address) {
        assertAllParamsNotNull(firstName, lastName,emailAddress,phoneNumber,password,address);
        this.userId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.role = Role.CUSTOMER;
        this.password = password;
        this.address = address;
        /**
         * Created an extra private constructor, otherwise Postman can't read the JSON.
         */
    }

    public String getUserId() {
        return userId;
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
