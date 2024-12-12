package com.springboot.web.controllers;

import com.springboot.web.models.User;
import com.springboot.web.models.dtos.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        return new UserDto(
                "Hello World...",
                new User("Jesus", "Finol", "Jesus@gmail.com")
        );
    }

    @GetMapping("/list")
    public List<User> listUsers(){
        return Arrays.asList(
                        new User("Jesus", "Finol"),
                        new User("John", "Doe"),
                        new User("Jane", "Doe")
        );
    }
}
