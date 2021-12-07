package com.switchfully.eurder.aop;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {

    //one logger to rule them all!
    private final Logger logger = LoggerFactory.getLogger(org.aspectj.lang.annotation.Aspect.class);

    @Pointcut("execution(* com.switchfully.eurder.*.*.*(..))")
    public void allDataRetrievalRepos() {}

    @Pointcut("execution(* com.switchfully.eurder.*.*.registerNewCustomer(com.switchfully.eurder.services.dtos.CreateUserDTO))")
    public void registerNewCustomer() {}



    @AfterThrowing( pointcut = "allDataRetrievalRepos()",
            throwing ="exception" )
    public void log(JoinPoint joinPoint, Throwable exception) {
        String message = exception.getMessage();
        String method = joinPoint.getSignature().toString();
        logger.warn(message.concat("This for the method: ").concat(method));
    }

    @AfterReturning( pointcut = "registerNewCustomer()"/*, returning = "userDTO"*/)
    public void logRegister(){
        String message = "Info: a new customer has been registered. ";
        logger.info(message);
    }

}
