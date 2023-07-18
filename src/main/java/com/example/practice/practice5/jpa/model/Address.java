package com.example.practice.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Auditable;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipcode;

    @OneToOne
    private Member member;

}
