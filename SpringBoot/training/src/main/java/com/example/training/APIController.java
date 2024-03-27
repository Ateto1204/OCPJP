package com.example.training;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping("/springboot")
    public String helloSpringBoot() {
        return "Hello, SpringBoot!";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        return "User create: " + user.getName();
    }
}