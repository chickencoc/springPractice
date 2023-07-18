package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Member;
import com.example.practice.practice5.jpa.model.Member3;
import com.example.practice.practice5.jpa.model.MemberLogHistory;
import com.example.practice.practice5.jpa.model.enums.Nation;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
//        Member member1 = new Member(1L, "홍길동", null, LocalDateTime.now(), LocalDateTime.now());
        // insert문
//        Member copyMember = memberRepository.save(member1); // insert into Member values (~~~
//        System.out.println("copyMember -> " + copyMember);

//        Member member =
        // select all문
        System.out.println("select all문--------------------------------------------------------");
        List<Member> memberList = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name")); // == select * from member
        // jdk 1.8에서 사용된 stream기술을 이용한 print찍는 방법
        memberList.forEach(System.out::println);
//        for(Member member : memberList) {
//            System.out.println(member.toString());
//        }

        // select where문
        System.out.println("select where문 --------------------------------------------------------");
        List<Member> memberList2 = memberRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)); // == select * from member where id in (1, 3)
        memberList2.forEach(System.out::println);

        // update문
        System.out.println("update문 --------------------------------------------------------");
//        Member member1 = new Member(1L, "홍길동", "hong@manhwa.com" , LocalDateTime.now(), LocalDateTime.now(), null);
        Member member1 = Member.builder()
                .id(1L)
                .name("홍길동")
                .email("hong@manhwa.com")
                .build();
        memberRepository.save(member1);     // 1번을 가진 id가 있다면 update, 없으면 create문 발생
        List<Member> memberList3 = memberRepository.findAll();
        memberList3.forEach(System.out::println);

        // delete문
//        System.out.println("delete문 --------------------------------------------------------");
        // delete를 한개씩 함
//        memberRepository.deleteAll();
        // delete를 한번에 함
//        memberRepository.deleteAllInBatch();
//        List<Member> memberList4 = memberRepository.findAll();
//        memberList4.forEach(System.out::println);
    }

    @Test
    void crud2() {
        // insert문(name과 create_at컬럼이 null이 아닌 insert)
        Member member = Member.builder()
//                .id(8L)
                .name("이명박")
                .build();
        memberRepository.save(member);
//
//        // insert문(update_at컬럼이 null이 아닌 insert)
        Member member2 = Member.builder()
//                .id(9L)
                .name("update_at컬럼이 null이 아닌 insert")
                .build();
        memberRepository.save(member2);

        // insert문(name: 박조은, email: parkjoeun@gmail.com, create_at: 현재시간)
//        Member member3 = new Member(15L, "박조은", "parkjoeun@gmail.com", LocalDateTime.now(), null, null);
        Member member3 = Member.builder()
                .name("박조은")
                .email("parkjoeun@gmail.com")
                .build();
        memberRepository.save(member3);

        // select(by)
//        Optional<Member> memberOptional = memberRepository.findById(10L);
//        memberOptional.orElseThrow(RuntimeException::new);
//        System.out.println(memberOptional);
        Member member4 = memberRepository.findById(1L).orElse(null);
        if (member != null) {
            System.out.println(member4);
        }

        // id: 7, 3을 가진 행값을 가져오는 select문을 만들어주는 java jpa코드 작성(finaAllbyId)
        List<Member> listMember = memberRepository.findAllById(Lists.newArrayList(7L,3L));
        listMember.forEach(System.out::println);

        // select count함수
        System.out.println("회원 수는 " + memberRepository.count() + "입니다");

        // select exist함수
        boolean isFiveNumberMember = memberRepository.existsById(5L);
        if (isFiveNumberMember)
            System.out.println("5번 회원 존재");
        boolean isNinetyNumberMember = memberRepository.existsById(90L);
        if (isNinetyNumberMember)
            System.out.println("90번 회원 존재");

        // select page함수
        Page<Member> membersPage = memberRepository.findAll(PageRequest.of(0, 4));
        System.out.println("page: " + membersPage);
        System.out.println("totalElements: " + membersPage.getTotalElements());
        System.out.println("totalPage: " + membersPage.getTotalPages());
        System.out.println("numberOfElements: " + membersPage.getNumberOfElements());
        System.out.println("sort: " + membersPage.getSort());
        System.out.println("size: " + membersPage.getSize());

        List<Member> memberList2 = membersPage.getContent();
        memberList2.forEach(System.out::println);

        // jpa find example이용(select)
        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", startsWith())
                ;
        Example<Member> memberExample = Example.of(
                Member.builder()
//                        .id(2L)
                        .name("홍길동")
//                        .email("ryukwansun@thejoeun.com")
                        .build(),
                matcher
        );
//        memberRepository.findAll(memberExample).forEach(System.out::println);

        Example<Member> memberExample2 = Example.of(Member.builder().name("mars").email("mars@thejoeun.com").build());
        memberRepository.findAll(memberExample2).forEach(System.out::println);
    }

    @DisplayName("semiProject sqlmapper관련 xml sql코드를 jpa 자바코드로 변환 테스트")
    @Test()
    void crudSemiSqlMapper() {

    }

    @Test()
    void jpaSchemaTest() throws InterruptedException {
        Member member = Member.builder()
                .name("이미라")
                .male(false)
                .email("imila@naver.com")
                .build();
        member = memberRepository.saveAndFlush(member); // insert

        Thread.sleep(1500) ;

        member.setName("김홍순");
        member.setUpdateAt(LocalDateTime.now());
        memberRepository.saveAndFlush(member);          // update
    }

    @Test()
    void jpaEnumTest() {
        Member member = Member.builder()
                .name("침착맨")
                .male(false)
                .email("chimchak@man.com")
                .nation(Nation.ENGLAND)
                .build();
        memberRepository.save(member);
    }

    @Test()
    void jpaEventListnerTest() {
        Member member = Member.builder()
                .name("홍승대")
                .male(false)
                .email("tmdeo@yahoo.com")
                .nation(Nation.ENGLAND)
                .build();
        memberRepository.save(member); //insert(PrePersist, PostPersist)

        Member member2 = memberRepository.findById(1L).orElseThrow(RuntimeException::new); // select(PostLoad)
        member2.setName("대홍승");
        memberRepository.save(member2);  // update(PreUpdate, PostUpdate)
        memberRepository.deleteById(3L); // delete(PreRemove, PostRemove)

    }

    @Autowired
    private Member3Repository member3Repository;

    @Test()
    void jpaEventListnerTest2() {
        Member3 member = Member3.builder()
                .name("홍승대")
                .email("tmdeo@yahoo.com")
                .build();
        member3Repository.save(member); //insert(PrePersist, PostPersist)

        Member3 member2 = member3Repository.findById(1L).orElseThrow(RuntimeException::new); // select(PostLoad)
        member2.setName("대홍승");
        member3Repository.save(member2);  // update(PreUpdate, PostUpdate)

    }

    @Autowired
    private MemberLogHistoryRepository memberLogHistoryRepository;

    @Test
    void getOneToManyTest() {
        Member member = Member.builder()
                .name("가나다")
                .email("ganada@membership.com")
                .build();
//        Member member2 = Member.builder()
//                .name("나다라")
//                .email("nadala@membership.com")
//                .build();
//        Member member3 = Member.builder()
//                .name("다라마")
//                .email("dalama@membership.com")
//                .build();

        memberRepository.save(member);
//        memberRepository.save(member2);
//        memberRepository.save(member3;
        Member memberCn = memberRepository.findByEmail("ganada@membership.com");

        memberCn.setName("한경주");
        memberRepository.save(memberCn);

        memberCn.setName("안경줘");
        memberRepository.save(memberCn);

        memberCn.setNation(Nation.OTHER);
        memberRepository.save(memberCn);

        List<MemberLogHistory>  memberLogHistoryList = memberRepository.findByEmail("ganada@membership.com").getMemberLogHistories();
        memberLogHistoryList.forEach(System.out::println);
        System.out.println("***");

//        List<Member> memberList = memberRepository.findAll();
//        Member memberL = memberList.get(2);
//        List<MemberLogHistory>  memberLogHistoryList = memberL.getMemberLogHistories();
//        System.out.println(">!@#>!@#> memberLogHistoryList: " + memberLogHistoryList);
//
//        List<MemberLogHistory> memberLogHistories = memberLogHistoryRepository.findByMemberId(memberL.getId());
//        memberRepository.findAll();

    }

}