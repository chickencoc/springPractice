package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {

}
