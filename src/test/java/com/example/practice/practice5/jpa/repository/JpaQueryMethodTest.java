package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Member;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.*;
import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class JpaQueryMethodTest {
    /*
    * Query return types
    * void - Demotes no return value.
    * primitives - java primitives.
    * Wrapper types - java wrapper types.
    *
    */
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void jpaQueryMethodTest1() {
        // SELECT문: email값으로 특정 row데이터 가져오기
        Set<Member> member1 = memberRepository.findByEmail("호영호@개미조.com");
        System.out.println("⬜⬜" + member1);

        System.out.println("\n------------------<><><>--------------------");

        // SELECT문: name값으로 특정 row데이터 가져오기
        List<Member> member2 = memberRepository.findByName("사영호");
        System.out.println("⬜⬜" + member2);

        System.out.println("\n------------------<><><>--------------------");

        Optional<Member> member3 = memberRepository.findByCreateAt(LocalDateTime.MAX);
        System.out.println("⬜⬜" + member3);

        System.out.println("\n------------------<><><>--------------------");

        System.out.println("⬜⬜ findByName: " + memberRepository.findByName("원영호"));
        System.out.println("⬜⬜ queryByName: " + memberRepository.queryByName("원영호"));
        System.out.println("⬜⬜ searchByName: " + memberRepository.searchByName("원영호"));
        System.out.println("⬜⬜ streamByName: " + memberRepository.streamByName("원영호"));
        System.out.println("⬜⬜ getByName: " + memberRepository.getByName("원영호"));
        System.out.println("⬜⬜ findMemberByName: " + memberRepository.findMemberByName("원영호"));
        System.out.println("⬜⬜ findSomethingByName: " + memberRepository.findSomethingByName("원영호"));
        // System.out.println("findByImgNo: " + memberRepository.findByImgNo("1"));  // error(img_no컬럼이 entity구성에 없기 때문


        System.out.println("\n------------------<><><>--------------------");

        // exists...by, count...by 쿼리 메소드
        System.out.println("⬜⬜ existsByName: " + memberRepository.existsByName("투영호"));
        System.out.println("⬜⬜ countByUpdateAt: " + memberRepository.countByUpdateAt(null));

        System.out.println("\n------------------<><><>--------------------");

        // topNumber, firstNumber, lastNumber
        System.out.println("⬜⬜ existsByName: " + memberRepository.existsByName("투영호"));


    }

    @Test
    void jpaQueryMethodTest2 () {
//        List<Member> memberList = memberRepository.findByNameAndEmail("홍길동", "mars@thejoeun.com");
//        memberList.forEach(s -> System.out.println(s));
//
//        List<Member> memberList2 = memberRepository.findByNameOrEmail("박남순", "mars@thejoeun.com");
//        memberList2.forEach(s -> System.out.println(s));

//        List<Member> memberList3 = memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//        memberList3.forEach(s -> System.out.println(s));

//        List<Member> memberList4 = memberRepository.findByCreateAtIsAfter(LocalDateTime.now().minusDays(1L));
//        memberList4.forEach(s -> System.out.println(s));

//        List<Member> memberList5 = memberRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L));
//        memberList5.forEach(s -> System.out.println(s));
//
//        List<Member> memberList6 = memberRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L));
//        memberList6.forEach(s -> System.out.println(s));

//        List<Member> memberList7 = memberRepository.findByIdGreaterThanEqual(3L);
//        memberList7.forEach(s -> System.out.println(s));
//
//        List<Member> memberList8 = memberRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusDays(-1L));
//        memberList8.forEach(s -> System.out.println(s));
//
//        List<Member> memberList9 = memberRepository.findByIdGreaterThanEqualAndIdLessThanEqual(3L,5L);
//        memberList9.forEach(s -> System.out.println(s));

        System.out.println("\n------------------<><><>--------------------");

        List<Member> memberList10 = memberRepository.findByNameLike("사영호");
        memberList10.forEach(s -> System.out.println(s));
        List<Member> memberList11 = memberRepository.findByNameIn(Lists.newArrayList("원영호", "투영호", "오영호"));
        memberList11.forEach(s -> System.out.println(s));

        System.out.println("\n------------------<><><>--------------------");
        
        List<Member> memberList12 = memberRepository.findByNameContains("사");
        memberList12.forEach(s -> System.out.println(s));

//        List<Member> memberList13 = memberRepository.findByNameStartWith("원");
//        memberList13.forEach(s -> System.out.println(s));

//        List<Member> memberList14 = memberRepository.findByNameOrderByName("원박사");
//        memberList14.forEach(s -> System.out.println(s));

        List<Member> memberList15 = memberRepository.findByNameOrderByIdDesc("호영호");
        memberList15.forEach(s -> System.out.println(s));

        System.out.println("\n------------------<><><>--------------------");

        Page<Member> pageMember = memberRepository.findByName("호영호", PageRequest.of(1, 3));
        List<Member> memberList16 = pageMember.getContent();
        memberList16.forEach(s -> System.out.println(s));


    }

}
