package com.switchfully.eurder.api;

import com.switchfully.eurder.customexceptions.*;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;

//todo: refactor this

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    protected void invalidInputException(InvalidInputException exception,
                                         HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgumentException(IllegalArgumentException exception,
                                            HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    protected void userNotAuthenticated(UnauthorizedException exception,
                                        HttpServletResponse response) throws IOException {
        response.sendError(FORBIDDEN.value(), exception.getMessage());
    }

    @ExceptionHandler(UnknownCustomerException.class)
    protected void unknownUser(UnknownCustomerException exception,
                               HttpServletResponse response) throws IOException{
        response.sendError(NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler(WrongPasswordException.class)
    protected void wrongPassword (WrongPasswordException exception,
                                  HttpServletResponse response) throws IOException{
        response.sendError(UNAUTHORIZED.value(), exception.getMessage());
    }

    @ExceptionHandler(NotUniqueException.class)
    protected void numberAlreadyExists(NotUniqueException exception,
                                       HttpServletResponse response) throws IOException{
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
    }

    //this happens when someone uses controller without providing header(login & pw), for endpoints with admin/customer difference. I.e. Postman
    @ExceptionHandler(MissingRequestHeaderException.class)
    protected void missingRequestHeaderException(MissingRequestHeaderException exception,
                                                 HttpServletResponse response) throws IOException{
        response.sendError(UNAUTHORIZED.value(),
                "You are not authorized to see this page. Please use a login & pw for this url. (" + exception.getMessage() + ")");
    }

    //catch-all test
    @ExceptionHandler(Exception.class)
    protected void otherException(Exception exception,
                                  HttpServletResponse response) throws IOException {
        response.sendError(response.getStatus(), "(this exception has no specific handler) " + exception.getMessage());
    }


}
