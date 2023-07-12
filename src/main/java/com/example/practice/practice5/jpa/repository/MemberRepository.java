package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    Member findByEmail(String email);

    Set<Member> findByEmail(String email);
    Optional<Member> findByCreateAt(LocalDateTime localDateTime);

    List<Member> findByName(String name);
    List<Member> queryByName(String name);
    List<Member> searchByName(String name);
    List<Member> streamByName(String name);
    List<Member> getByName(String name);
    List<Member> findMemberByName(String name);
    List<Member> findSomethingByName(String name);
    Boolean existsByName(String name);
    Long countByUpdateAt(LocalDateTime updateAt);


    List<Member> findByNameAndEmail(String name, String email);
    List<Member> findByNameOrEmail(String name, String email);
    List<Member> findByIdGreaterThanEqual(long yesterday);
    List<Member> findByCreateAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);
    List<Member> findByNameLike(String likeName);
    List<Member> findByNameIn(List<String> listMember);

    List<Member> findByNameContains(String name);
    List<Member> findByNameOrderByName(String name);
    List<Member> findByNameOrderByIdDesc(String name);

    Page<Member> findByName(String name, Pageable pageable);






}


