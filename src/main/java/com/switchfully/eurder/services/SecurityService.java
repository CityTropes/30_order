package com.switchfully.eurder.services;


import com.switchfully.eurder.customexceptions.UnauthorizedException;
import com.switchfully.eurder.customexceptions.UnknownCustomerException;
import com.switchfully.eurder.customexceptions.WrongPasswordException;
import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.security.Role;
import com.switchfully.eurder.security.SecureUser;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {

    //todo: logger!

    private final UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateAuthorization(String authorization, Feature feature){
        if(authorization == null) {
            throw new UnauthorizedException();
        }
        SecureUser emailPassword = getEmailAndPassword(authorization);
        User user = userRepository.getUser(emailPassword.getEmail());
        if(user == null) {
            throw new UnauthorizedException();
        }
        if(!canHaveAccessTo(feature, user.getRole())) {
            throw new UnauthorizedException();
        }
        if(!doesPasswordMatch(emailPassword.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }
        return user;
    }

    public boolean canHaveAccessTo(Feature feature, Role role) {
        return role.getListOfFeatures().contains(feature);
    }

    protected boolean doesPasswordMatch(String givenPassword, String userPassword) {
        return givenPassword.equals(userPassword);
    }

    private SecureUser getEmailAndPassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new SecureUser(username, password);
    }
}
