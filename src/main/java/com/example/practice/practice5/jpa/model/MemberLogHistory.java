package com.example.practice.practice5.jpa.model;

import com.example.practice.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(TimeAuditEntityListener.class)
public class MemberLogHistory implements TimeAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    private String name;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Nation nation;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}