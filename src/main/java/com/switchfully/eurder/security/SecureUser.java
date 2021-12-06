package com.switchfully.eurder.security;

public class SecureUser {
    private final String email;
    private final String password;

    public SecureUser(String email, String password) {
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
