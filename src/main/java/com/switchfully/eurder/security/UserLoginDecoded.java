package com.switchfully.eurder.security;

public class UserLoginDecoded {

    private final String email;
    private final String password;

    public UserLoginDecoded(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
