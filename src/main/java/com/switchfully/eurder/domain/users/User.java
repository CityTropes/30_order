package com.switchfully.eurder.domain.users;

import com.switchfully.eurder.security.Role;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private String emailAddress;            //email = login/username
    private Address address;
    private String phoneNumber;

    private Role role;
    private String password;        //temporary 'security'

    public User(String firstName, String lastName, String emailAddress, Address address, String phoneNumber, String password) {
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

    public void promoteRoleToAdmin() {
        this.role = Role.ADMIN;
    }

    public void demoteRoleToCustomer(){
        this.role = Role.CUSTOMER;
    }

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