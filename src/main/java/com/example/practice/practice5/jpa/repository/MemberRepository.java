package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

