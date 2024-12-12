package com.springboot.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Order(1)
@Component
public class GreetingFooAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value = "greetingFooLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("(1) - Inicio de llamada al metodo: " + method + " con los parametros " + args);
    }
}
