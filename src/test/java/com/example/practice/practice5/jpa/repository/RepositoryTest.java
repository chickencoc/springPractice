package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Address;
import com.example.practice.practice5.jpa.model.Book;
import com.example.practice.practice5.jpa.model.BookReviewInfo;
import com.example.practice.practice5.jpa.model.Member;
import com.example.practice.practice5.jpa.model.enums.Nation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    void bookRepositoryTest() throws InterruptedException {
        Book book1 = Book.builder()
                .name("표준orm JPA 프로그래밍")
                .build();

        Book book2 = bookRepository.save(book1);

//        Thread.sleep(1000);
//
//        book2.setAuthor("박봉남");
//        bookRepository.save(book2);
    }

    @Test
    void addressRepositoryTest() throws InterruptedException {
        Address address = Address.builder()
                .zipcode("24309")
                .build();

        addressRepository.save(address);

        Thread.sleep(200);

        Address address2 = Address.builder()
                .zipcode("13115")
                .build();

        addressRepository.save(address2);
    }

    @Autowired
    MemberRepository memberRepository;

    @Test
    void crudTestAddress() {
        Address address = Address.builder()
                .zipcode("23113")
                .build();

        addressRepository.save(address);
    }

    @Test
    void oneToOneTest1() {
        Member member = getGivenMember();
        Address address = getGivenAdress(member);

        addressRepository.findById(1L);
    }

    private Member getGivenMember() {
        Member member = Member.builder()
                .name("리멤버")
                .email("imMember@membership.com")
                .male(false)
                .nation(Nation.OTHER)
                .build();
        return memberRepository.save(member);
    }
    private Address getGivenAdress(Member member) {
        Address address = Address.builder()
                .member(member)
                .zipcode("98423")
                .build();

        return addressRepository.save(address);
    }

    @AfterEach
    void tearDown() {}
}
