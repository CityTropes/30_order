package com.switchfully.eurder.customexceptions;

public class UnknownItemException extends RuntimeException{

    public UnknownItemException() {
        this("Item not found!");
    }

    public UnknownItemException(String message) {
        super(message);
    }
}
