package com.example.practice.practice2.springIoc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocApp2 {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocApp2.class, args);
        ApplicationContext ac = ApplicationContextProvider2.getApplicationContext();
    }
}
