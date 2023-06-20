package com.example.todolistspringbootintership.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequestCounterAspect {
    private int requestCount;

    @Pointcut("execution(public * com.example.todolistspringbootintership.controllers.*.*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void incrementRequestCount() {
        requestCount++;
    }

    @After("controllerMethods()")
    public void logRequestCount() {
        System.out.println("Total request count: " + requestCount);
    }
}
