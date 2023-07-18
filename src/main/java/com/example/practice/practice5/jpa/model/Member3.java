package com.example.practice.practice5.jpa.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Data
@ToString
@EntityListeners({MemberEntityListener.class})
@EqualsAndHashCode(callSuper=true)
public class Member3 extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String email;
}