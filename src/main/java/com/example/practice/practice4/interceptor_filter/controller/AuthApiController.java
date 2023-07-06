package com.example.practice.practice4.interceptor_filter.controller;

import com.example.practice.practice4.interceptor_filter.annotations.AuthUser;
import com.example.practice.practice4.interceptor_filter.dto.User4F;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authapi")
@AuthUser
public class AuthApiController {
    @GetMapping("/get")
    public String user() {
        return "Requested 'authapi/get'";
    }

    @PostMapping("/user")
    public User4F user(User4F user) {

        return user;
    }
}
