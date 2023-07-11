package com.example.practice.practice5.lombok;

import com.example.practice.practice5.lombok.model.User;

public class LombokTestApplication {
    public static void main(String[] args) {
        User u = new User();
        u.setName("add");
        u.setEmail("add@spring.com");
        System.out.println("NAME: " + u.getName());
        System.out.println("EMAIL: " + u.getEmail());

        User user4 = new User();

        System.out.println("------------------------------");
        System.out.println(user4.getName());
        System.out.println(user4.getEmail());
    }
}
