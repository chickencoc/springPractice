package com.example.practice.practice1;

import org.springframework.web.bind.annotation.*;

@RestController
public class MvcController1 {

    // @RequestMapping("/test1")
    @GetMapping(value = "/test1")
    public String test1() {
        System.out.println("changed");
        return "test1입니다.sfdgsdfgsdfg";
    }
    @GetMapping("/test2View")
    public String test2() {
        return "test2";
    }

    // 데이터 등록 메소드이다.
    @PostMapping(value = "/postTest1")
    public String postTEst1() {
        return """
                {
                "name": "홍길동ㅂ",
                 "age": "40"
                }
                """;
    }

    @PutMapping("/putTest1")
    public String putTest1() {
        return "put은 업데이트 http 메소드 입니다.";
    }

    @DeleteMapping("/deleteTest1")
    public String deleteTest1() {
        return "delete는 삭제 http 메소드 입니다.";
    }
}
