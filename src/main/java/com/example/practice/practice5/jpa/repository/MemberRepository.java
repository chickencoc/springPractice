package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Member;
import com.example.practice.practice5.jpa.model.Somthing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    Member findByEmail(String email);

    Set<Member> readByEmail(String email);
    Member findByEmail(String email);
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


//    JPQL
    @Query(value = "select m from Member m where name = ?1")
    List<Member> selectByMemb(String name);

    @Query(value = "select m from Member m where name = ?2 and id = ?1")
    List<Member> selectByMembId(Long id, String name);

    @Query(value = "select m.name from Member m where name = ?1")
    List<String> selectNameByMemb(String name);

    @Query(value = "select m.id id, m.name name from Member m where name = :name")
    List<Map<String, Object>> selectNameAndIdByMemb(@Param("name") String name);

    @Query(value = """
            select *
            from Member
            where name = :name
            """, nativeQuery = true)
    List<Member> selectByNativeMemb(String name);


}


