package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
