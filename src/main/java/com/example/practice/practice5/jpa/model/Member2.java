package com.example.practice.practice5.jpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
@ToString
//@Table(name = "member", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}, indexes = {@Index(columnList = "email"), @Index(columnList = "name")})
@Table(name = "member2", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Member2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String email;
    private String email2;
}