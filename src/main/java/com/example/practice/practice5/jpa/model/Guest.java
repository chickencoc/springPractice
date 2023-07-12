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
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"userid"})})
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long guestno;
    @NonNull
    private String userid;
    private String gPhone;
    private String gAddrNo;
    private String gAddr1;
    private String gAddr2;
    @NonNull
    private String gName;
    private String orderno;
}