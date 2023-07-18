package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Crew;
import com.example.practice.practice5.jpa.model.Member;
import com.example.practice.practice5.jpa.model.Somthing;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import jdk.dynalink.linker.GuardingDynamicLinker;
import org.hibernate.exception.spi.ViolatedConstraintNameExtractor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void entityManagerTest() {
        em.createQuery("select u from Member u").getResultList().forEach(s -> System.out.println(s));
    }

    @Test
    @Transactional
    void cacheEntityFindTest() {
        System.out.println(memberRepository.findByEmail("삼영호@개미조.com"));
        System.out.println(memberRepository.findByEmail("삼영호@개미조.com"));
        System.out.println(memberRepository.findByEmail("삼영호@개미조.com"));
    }

    @Test
    void cacheEntityFindTest2() {
        Member member = memberRepository.findById(1L).get();
        member.setName("지우개");

        memberRepository.save(member);
        memberRepository.flush();
        System.out.println("🟡>>> >>> >>> >>>");

        member.setEmail("abcde@alphabet.com");

        memberRepository.save(member);
        memberRepository.flush();
        System.out.println("🟡>>> >>> >>> >>>");
    }
    
    @Test
    @Transactional // OSIV (Open Session In View) -> transaction
    void entityManagerTest2() {
        Member member = Member.builder()
                .name("ahahahah")
                .email("ohriRhkr@naver.com")
                .build();
        em.persist(member); // jpa 영속성 관리에 저장

        memberRepository.findAll().forEach(System.out::println);
    }

    @Autowired
    CrewRepository crewRepository;

    @Test
    @Transactional
    void entityManagerTest3() {
        Crew crew = Crew.builder()
                .name("닭닥이")
                .build();
        em.persist(crew); // 영속성 상태

        em.detach(crew); // 준영속성 상태
        em.merge(crew); // 준영속성 상태에서 영속성 상태로 변경
//        em.remove(crew); // 비영속성으로 삭제 상태

        crewRepository.findAll().forEach(System.out::println);
    }

    /**
     * <p>cache</p>
     * <p>persist</p>
     * <p>detach, merge, remove, clear</p>
     * <p>변경감지, 쓰기지연, 지연로딩(LAZY) - 연관 관계 매핑 기본값, 즉시로딩(EAGER)</p>
     * <p>transaction, commit, rollback, flush</p>
    * */
    @Test
    void persistCacheDelayInsertUpdateTest() {
        Crew crew = crewRepository.findById(1L).get();
        crew.setName("원길동");

        crewRepository.save(crew);

        crew.setEmail("Wdong@crews.net");

        crewRepository.save(crew);
    }

    @Test
    void jpqlTestMember() {
        List<Member> memberList1 = memberRepository.selectByMemb("투영호");
        memberList1.forEach(System.out::println);

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

        List<Member> memberList2 = memberRepository.selectByMembId(2L, "투영호");
        memberList2.forEach(System.out::println);

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

        List<String> memberList3 = memberRepository.selectNameByMemb("투영호");
        memberList3.forEach(System.out::println);

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

        List<Map<String, Object>> memberList4 = memberRepository.selectNameAndIdByMemb("원영호");
        memberList4.forEach(x -> System.out.println(x.entrySet()));

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

        List<Member> memberList5 = memberRepository.selectByNativeMemb("삼영호");
        memberList5.forEach(System.out::println);

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

    }

    @Autowired
    BookRepository bookRepository;

    @Test
    void jpqlTestBook() {

        List<Somthing> somthingList1 = bookRepository.selectBySome(1L);
        somthingList1.forEach(x -> System.out.println(x.getIds() + ", " + x.getText1()));

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

        List<Somthing> somthingList2 = bookRepository.selectByNativeSome(3L);
        somthingList2.forEach(x -> System.out.println(x.getIds() + ", " + x.getText1() + ", " + x.getText2()));

        System.out.println("🟥🟥--------------------------------------------🟥🟥");

    }



}
