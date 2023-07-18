package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Member;
import com.example.practice.practice5.jpa.model.MemberLogHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberLogHistoryRepository extends JpaRepository<MemberLogHistory, Long> {
    List<MemberLogHistory> findByMemberId(Long memberId);
}
