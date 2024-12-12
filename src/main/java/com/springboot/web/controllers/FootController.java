package com.springboot.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/v1/app")
public class FootController {

    @RequestMapping("/foo")
    public Map<String, String> foo() {
        return Collections.singletonMap("message", "Hello World foo");
    }

    @RequestMapping("/bar")
    public Map<String, String> bar() {
        return Collections.singletonMap("message", "Hello World bar");
    }

    @RequestMapping("/baz")
    public Map<String, String> baz() {
        return Collections.singletonMap("message", "Hello World baz");
    }
}
