package com.switchfully.eurder.api;

import com.switchfully.eurder.customexceptions.NotUniqueException;
import com.switchfully.eurder.customexceptions.UnauthorizedException;
import com.switchfully.eurder.customexceptions.UnknownCustomerException;
import com.switchfully.eurder.customexceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgumentException(IllegalArgumentException iae,
                                            HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), iae.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected void userNotAuthenticated(UnauthorizedException ue,
                                        HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), ue.getMessage());
    }

    @ExceptionHandler(UnknownCustomerException.class)
    protected void unknownUser(UnknownCustomerException uue,
                               HttpServletResponse response) throws IOException{
        response.sendError(NOT_FOUND.value(), uue.getMessage());
    }

    @ExceptionHandler(WrongPasswordException.class)
    protected void wrongPassword (WrongPasswordException wpe,
                                  HttpServletResponse response) throws IOException{
        response.sendError(NOT_FOUND.value(), wpe.getMessage());
    }

    @ExceptionHandler(NotUniqueException.class)
    protected void securityNumberAlreadyExists (NotUniqueException ssnrae,
                                                HttpServletResponse response) throws IOException{
        response.sendError(BAD_REQUEST.value(), ssnrae.getMessage());
    }


}
