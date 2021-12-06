package com.switchfully.eurder.customexceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        this("You are not authorized to access this info. ");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
