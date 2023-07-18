package com.example.practice.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Entity
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "publisher ")
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books;

}
