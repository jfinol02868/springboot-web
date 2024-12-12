package com.springboot.web.configuration;

import com.springboot.web.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/aspect")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/greeting")
    public ResponseEntity<Map<String, String>> greeting() {
        Map<String, String> map = new HashMap();
        map.put("greeting", greetingService.sayHello("Jesus", "Hello"));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping("/greeting2")
    public ResponseEntity<Map<String, String>> greetingError() {
        Map<String, String> map = new HashMap();
        map.put("greeting", greetingService.sayHelloError("Jesus", "Hello"));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
