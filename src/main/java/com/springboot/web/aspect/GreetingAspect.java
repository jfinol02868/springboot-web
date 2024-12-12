package com.springboot.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(2)
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    // Antes de llamar a el metodo sayHello de GreetingService
    // '*' Cualquier tipo de retorno
    // 'GreetingService.*' cualquier metodo de GreetingService
    @Before(value = "greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("(2) - Inicio de llamada al metodo: " + method + " con los argumentos " + args);
    }

    // Despues de llamar a el metodo sayHello de GreetingService
    @After(value = "greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("(2) - Fin de llamada al metodo: " + method + " con los argumentos " + args);
    }

    // Despues de retornar la llamar a el metodo sayHello de GreetingService
    @AfterReturning(value = "greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("(2) - Despues de retornar en el metodo: " + method + " con los argumentos " + args);
    }

    @AfterThrowing(value = "greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("(2) - Despues de lanzar la excepcion en el metodo: " + method + " con los argumentos " + args);
    }

    @Around(value = "greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("(2) - Around::Antes de ejecutar el metodo: " + method + " con los argumentos " + args);
        Object result = joinPoint.proceed();
        logger.info("(2) - Around::Despues de ejecutar el metodo: " + method + " con los argumentos " + args);
        return result;
    }
}
