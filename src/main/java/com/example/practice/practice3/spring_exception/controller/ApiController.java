package com.example.practice.practice3.spring_exception.controller;

import com.example.practice.practice3.spring_exception.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    // 특정 사용자 정보를 조회하는 api ( /api/user?name=홍길동&age=40 )
    @GetMapping("/user")
    public String user(@Size(min = 2) @RequestParam String name, @RequestParam int age) {

        return "이름: " + name + ", 나이: " + age;
    }

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

}
