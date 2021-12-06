package com.switchfully.eurder.domain.users;

public class Address {

    private final String streetName;
    private final int streetNumber;
    private final int postalCode;
    private final String city;

    public Address(String streetName, int streetNumber, int postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    /**
     * builder is possible -> watch constructors: private Address(Builder builder) +
     * extra constructor (or postman can't read JSON): private Address(String streetName, int streetNumber, int postalCode, String city)
     */
}
