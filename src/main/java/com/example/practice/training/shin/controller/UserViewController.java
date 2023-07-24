package com.example.practice.training.shin.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/")
    public String main() {
        return "redirect:/articles";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/oauth2login")
    public String oauth2login() {
        return "oauth2login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
