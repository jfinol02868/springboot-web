package com.springboot.web.services;

public interface GreetingService {

    String sayHello(String person, String phrase);

    String sayHelloError(String person, String phrase);
}
