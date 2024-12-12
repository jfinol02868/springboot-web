package com.springboot.web.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {

    @Pointcut("execution(* com.springboot.web.services.GreetingService.*(..))")
    private void greetingLoggerPointCut() {}

    @Pointcut("execution(* com.springboot.web.services.GreetingService.*(..))")
    private void greetingFooLoggerPointCut() {}
}
