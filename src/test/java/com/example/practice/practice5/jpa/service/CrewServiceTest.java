package com.example.practice.practice5.jpa.service;

import com.example.practice.practice5.lombok.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CrewServiceTest {

    @Autowired
    private CrewService crewService;

    /**
     * transaction을 외부에서 메소드로 호출하면 적용이 잘됨.
     * */
    @Test
    void transactionTest() {
        crewService.put();
    }

}