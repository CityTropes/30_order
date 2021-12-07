package com.switchfully.eurder.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {

    //one logger to rule them all!
    private final Logger logger = LoggerFactory.getLogger(org.aspectj.lang.annotation.Aspect.class);

    @Pointcut("execution(* com.switchfully.eurder.*.*.*(..))")
    public void catchAllExceptionsInAllMethods() {}

    @Pointcut("execution(* com.switchfully.eurder.*.*.registerNewCustomer(com.switchfully.eurder.services.dtos.CreateUserDTO))")
    public void registerNewCustomer() {}

    @Pointcut("execution(* com.switchfully.eurder.*.*.saveItem(..))")
    public void addNewItem() {}


    @AfterThrowing( pointcut = "catchAllExceptionsInAllMethods()", throwing ="exception" )
    public void logExceptions(JoinPoint joinPoint, Throwable exception) {
        String message = exception.getMessage();
        String method = joinPoint.getSignature().toString();
        logger.warn(message.concat(" Triggered by method: ").concat(method));
    }

    @AfterReturning( pointcut = "registerNewCustomer()"/*, returning = "userDTO"*/)
    public void logRegisterNewCustomer(){
        logger.info("Info: a new customer has been registered. ");
    }


    @AfterReturning( pointcut = "addNewItem()"/*, returning = "userDTO"*/)
    public void logAddNewItem(){
        logger.info("Info: a new item  has been added. ");
    }

}
