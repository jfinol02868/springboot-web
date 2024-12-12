package com.springboot.web.controllers;

import com.springboot.web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Jesus", "Finol");
        model.addAttribute("tittle", "Hello World...");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        model.addAttribute("tittle", "List of Users");
        return "list";
    }

    // Pasar dartos comunes a una vista
    @ModelAttribute("users")
    private List<User> usersModel(){
       return Arrays.asList(
                new User("Jesus", "Finol"),
                new User("John", "Doe", "john@gmail.com"),
                new User("Jane", "Doe")
        );
    }
}
