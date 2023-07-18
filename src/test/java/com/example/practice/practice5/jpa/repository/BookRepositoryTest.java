package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Book;
import com.example.practice.practice5.jpa.model.Member;
import com.example.practice.practice5.jpa.model.Publisher;
import com.example.practice.practice5.jpa.model.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void bookTest() {
        Book book = Book.builder()
                .name("스프링은 어렵다. 하지만 봄은 3월이다.")
                .build();

        bookRepository.save(book);
    }

    @Test
    void relationTest1() {
        givenBookAndReview();
    }

    private void givenPublisher() {
        Publisher publisher = Publisher.builder()
                .name("조은출판사")
                .build();
        publisherRepository.save(publisher);
    }
    private void givenBookAndReview() {
        givenReview(givenMember(), givenBook());
    }
    private Review givenReview(Member member, Book book) {
        Review review = Review.builder()
                .title("너무 재미있는 책")
                .member(member)
                .book(book)
                .build();
        return reviewRepository.save(review);
    }
    private Member givenMember() {
        return memberRepository.findByEmail("amsun@thejoeun.com");
    }
    private Book givenBook() {
        Book book = Book.builder()
                .name("React와 스프링 부트로 만들기 프로젝트")
//                .author("저자1")
                .build();
        return bookRepository.save(book);
    }

    @Test
    void updateJpaTest1() {
        int isUpdate = bookRepository.updateSpecificNameByJPQL(2L);
        System.out.println("2번 id를 가진 book의 이름" + (isUpdate > 0 ? " 바뀜" : " 바뀌지 않음") + ", isUpdate 값 : " + isUpdate);
    }



}