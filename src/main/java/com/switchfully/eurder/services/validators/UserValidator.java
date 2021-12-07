package com.switchfully.eurder.services.validators;

import com.switchfully.eurder.customexceptions.InvalidInputException;
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

    private boolean assertEmailAddressIsUnique(CreateUserDTO userToCheck, UserRepository userRepository) {
        return userRepository.getMapOfAllUsersById()
                .values()
                .stream()
                .map(getEmailUser)
                .noneMatch(email -> email.equals(userToCheck.getEmailAddress()
                        .replaceAll("\\s+", "")
                        .toLowerCase()));
    }

    private boolean assertNoFieldsAreNullOrEmpty(CreateUserDTO createUserDTO){
        assertNotNullOrEmpty(createUserDTO.getEmailAddress());
        assertNotNullOrEmpty(createUserDTO.getFirstName());
        assertNotNullOrEmpty(createUserDTO.getLastName());
        assertNotNullOrEmpty(createUserDTO.getAddress().getStreetName());
        assertNotNullOrEmpty(createUserDTO.getAddress().getCity());
        assertNotNullOrEmpty(createUserDTO.getPhoneNumber());
        return true;
    }

    private void assertNotNullOrEmpty(String input){
        if(input == null || input.trim().equals("")){
            throw new InvalidInputException("The given input can't contain null or empty fields (in user and address)! ");
        }
    }

    public boolean canUserBeSaved(CreateUserDTO createUserDTO , UserRepository userRepository) {
        return assertEmailAddressIsUnique(createUserDTO, userRepository)
                && validateEmail(createUserDTO)
                && assertNoFieldsAreNullOrEmpty(createUserDTO);
    }

    //todo: nullcheck when creating new user, address, item, ...

}
