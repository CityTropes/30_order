package com.switchfully.eurder.services.validators;

import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.services.dtos.CreateUserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserValidator {
    private final Function<User, String> getEmailUser = user -> user.getEmailAddress()
            .replaceAll("\\s+","")
            .toLowerCase();

    public boolean validateEmail(CreateUserDTO createUserDTO) {
        return RegexPattern.emailPattern.matcher(createUserDTO.getEmailAddress()).matches();
    }


    /*
    private boolean checkEmailUser(CreateUserDTO userToCheck, UserRepository userRepository) {
        return userRepository.getUsersById()
                .values()
                .stream()
                .map(getEmailUser)
                .noneMatch(email -> email.equals(userToCheck.getEmailAddress()
                        .replaceAll("\\s+", "")
                        .toLowerCase()));
    }

     */

}
