package com.example.practice.practice5.jpa.model;


import com.example.practice.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Table(name = "member")
@EntityListeners(value = {AuditingEntityListener.class, MemberEntityListener.class})
public class Member extends BaseEntity {
//    @Id / @GeneratedValue - https://rutgo-letsgo.tistory.com/306
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue
    private Long id;
//    @NonNull
    @Column(nullable = false, columnDefinition = "varchar(100) comment '멤버이름'")
    private String name;
    private String email;

    @Column(name = "colTest2", unique = true)
    private Integer test2;

    private Boolean male;

     /*
    @Transient는  javax.persistence 패키지에 포함되어있는 컬럼 매핑 레퍼런스 애노테이션,
    엔티티 객체의 데이터와 테이블의 컬럼(column)과 매핑하고 있는 관계를 제외하기 위해 사용합니다.
    영속 대상에서 제외시키기 위해 사용한다고 이해하셔야 합니다.
    */
    @Transient
    private String test3;

    @Column(columnDefinition = "enum")
    @Enumerated(value = EnumType.STRING)
    private Nation nation;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private List<MemberLogHistory> memberLogHistories;


//    -------------------------------------------------------

    @PrePersist
    public void preInsert1() {
        System.out.println("🟢>>> preInsert1()");
    }
    @PreUpdate
    public void preUpdate1() {
        System.out.println("🟢>>> preUpdate1()");
    }
    @PreRemove
    public void preDelete1() {
        System.out.println("🟢>>> preDelete1()");
    }
    @PostPersist
    public void afterInsert1() {
        System.out.println("🟢>>> afterInsert1()");
    }
    @PostUpdate
    public void afterUpdate1() {
        System.out.println("🟢>>> afterUpdate1()");
    }
    @PostRemove
    public void afterDelete1() {
        System.out.println("🟢>>> afterDelete1()");
    }
    @PostLoad
    public void afterSelect1() {
        System.out.println("🟢>>> afterSelect1()");
    }
}