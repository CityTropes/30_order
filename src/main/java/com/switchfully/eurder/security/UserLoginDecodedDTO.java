package com.switchfully.eurder.security;

public class UserLoginDecodedDTO {

    private final String email;
    private final String password;

    public UserLoginDecodedDTO(String email, String password) {
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
