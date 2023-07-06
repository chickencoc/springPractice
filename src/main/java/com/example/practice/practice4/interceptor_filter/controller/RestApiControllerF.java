package com.example.practice.practice4.interceptor_filter.controller;

import com.example.practice.practice4.interceptor_filter.dto.User4F;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aopfilter")
public class RestApiControllerF {
    @GetMapping("/user/{id}")
    public String user(@PathVariable String id, @RequestParam(required = false, defaultValue = "오리꽉") String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return id + ", " + name;
    }

    @PostMapping("/user")
    public User4F user(User4F user) {

        return user;
    }
}
