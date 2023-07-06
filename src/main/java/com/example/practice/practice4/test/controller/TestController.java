package com.example.practice.practice4.test.controller;

import com.example.practice.practice4.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public List<String> getAllStringsVal() {
        return testService.getAllStringVal();
    }
}
