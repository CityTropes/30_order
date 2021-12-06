package com.switchfully.eurder.domain.users;

import com.switchfully.eurder.security.Role;

import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private String emailAddress;            //email = login/username
    private Address address;
    private String phoneNumber;

    private Role role;
    private String password;        //temporary 'security'

    public Customer(String firstName, String lastName, String emailAddress, Address address, String phoneNumber, String password) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = Role.CUSTOMER;
        this.password = password;
    }

    //todo: maybe replace with builder (obligated final fields)


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }
}
