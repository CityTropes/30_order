package com.switchfully.eurder.services.dtos;

import com.switchfully.eurder.security.Role;

import java.util.Objects;
import java.util.UUID;

public class UserDTO {

    private final UUID userId;
    private String emailLogin;
    private final String firsName;
    private final String lastName;
    private final Role role;

    public UserDTO(UUID userId, String emailLogin, String firsName, String lastName, Role role) {
        this.userId = userId;
        this.emailLogin = emailLogin;
        this.firsName = firsName;
        this.lastName = lastName;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return userId.equals(userDTO.userId) && emailLogin.equals(userDTO.emailLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, emailLogin);
    }
}
