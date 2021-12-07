package com.switchfully.eurder.services;

import com.switchfully.eurder.customexceptions.UnauthorizedException;
import com.switchfully.eurder.customexceptions.WrongPasswordException;
import com.switchfully.eurder.domain.users.User;
import com.switchfully.eurder.repositories.UserRepository;
import com.switchfully.eurder.security.Feature;
import com.switchfully.eurder.security.Role;
import com.switchfully.eurder.security.UserLoginDecodedDTO;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {

    private final UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateAuthorization(String authorization, Feature feature){
        if(authorization == null) {
            throw new UnauthorizedException();
        }
        UserLoginDecodedDTO emailPasswordCombo = extractAndDecodeEmailAndPassword(authorization);
        User user = userRepository.getUser(emailPasswordCombo.getEmail());
        if(user == null) {
            throw new UnauthorizedException();
        }
        if(!canHaveAccessTo(feature, user.getRole())) {
            throw new UnauthorizedException();
        }
        if(!doesPasswordMatch(emailPasswordCombo.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }
        return user;
    }

    private UserLoginDecodedDTO extractAndDecodeEmailAndPassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new UserLoginDecodedDTO(username, password);
    }

    public boolean canHaveAccessTo(Feature feature, Role role) {
        return role.getListOfFeatures().contains(feature);
    }

    protected boolean doesPasswordMatch(String givenPassword, String userPassword) {
        return givenPassword.equals(userPassword);
    }


}
