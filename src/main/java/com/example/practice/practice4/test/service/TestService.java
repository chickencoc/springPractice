package com.example.practice.practice4.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class TestService {
    @Autowired
    private TestService testService;

    public List<String> getAllStringVal() {
        return Arrays.asList("abc", "xyz");
    }
}
