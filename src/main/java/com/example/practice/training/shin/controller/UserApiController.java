package com.example.practice.training.shin.controller;

import com.example.practice.training.shin.model.dto.AddUserRequest;
import com.example.practice.training.shin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.register(request);

        return "redirect:/login";
    }
}
