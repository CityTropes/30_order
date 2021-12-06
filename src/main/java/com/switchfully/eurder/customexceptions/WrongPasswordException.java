package com.switchfully.eurder.customexceptions;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException() {this("The given password is not correct!");}

    public WrongPasswordException(String message) {
        super(message);
    }
}
