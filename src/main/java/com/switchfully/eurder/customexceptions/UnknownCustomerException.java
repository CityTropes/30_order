package com.switchfully.eurder.customexceptions;

public class UnknownCustomerException extends RuntimeException{

    public UnknownCustomerException() {
        this("Customer not found!");
    }

    public UnknownCustomerException(String message) {
        super(message);
    }
}
