package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Book;
import com.example.practice.practice5.jpa.model.BookReviewInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void crudTest1() {
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .bookId(1L)
                .avgReviewScore(3.6f)
                .reviewCount(129)
                .build();

        bookReviewInfoRepository.save(bookReviewInfo);
    }
    @Test
    void crudTest2() {
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
//                .bookId(2L)
                .avgReviewScore(4.8f)
                .reviewCount(4123)
                .build();

        bookReviewInfoRepository.save(bookReviewInfo);
    }

    @Test
    void oneToOneTest1() {
        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = getGivenBookReviewInfo(book);

        bookReviewInfoRepository.findById(1L);
    }

    private Book getGivenBook() {
        Book book = Book.builder()
                .name("아주 쉬운 스프링 부트3.1")
                .build();
        return bookRepository.save(book);
    }
    private BookReviewInfo getGivenBookReviewInfo(Book book) {
//        Book book = getGivenBook();
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(book)
                .avgReviewScore(2.3f)
                .reviewCount(8)
                .build();

        return bookReviewInfoRepository.save(bookReviewInfo);
    }

    @AfterEach
    void tearDown() {
        System.out.println("🟩");
    }
}