package com.example.practice.practice5.jpa.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Getter
//@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
//@EntityListeners(value = {AuditingEntityListener.class})
public class Book extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Review> reviews;

    @ManyToMany
    @ToString.Exclude
    private List<Author> authors;

}
