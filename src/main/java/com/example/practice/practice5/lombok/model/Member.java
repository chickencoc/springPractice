package com.example.practice.practice5.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, requiredArgsConstructor, tostring.....
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String name;
    private String age;
    private Long id;
}
