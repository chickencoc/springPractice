package com.example.practice.practice4.aop.controller;

import com.example.practice.practice4.aop.annotation.TimeChecker;
import com.example.practice.practice4.aop.dto.User4;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aop")
public class RestApiController {
    @TimeChecker
    @GetMapping("/user/{id}")
    public String user(@PathVariable String id, @RequestParam(required = false, defaultValue = "오리꽉") String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return id + ", " + name;
    }

    @PostMapping("/user")
    public User4 user(User4 user) {

        return user;
    }

    @PutMapping("/user")
    public User4 update(User4 user) {
        return user;
    }

}
