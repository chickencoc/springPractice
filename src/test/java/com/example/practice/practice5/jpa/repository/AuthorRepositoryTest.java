package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Author;
import com.example.practice.practice5.jpa.model.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void manyToManyTest() {
        Book book1 = givenBook("Easy React!");
        Book book2 = givenBook("Easy React Native!");
        Book book3 = givenBook("Easy Spring Boot");
        Book book4 = givenBook("Easy Spring Data JPA");

        Author author1 = givenAuthor("Knight Park");
        Author author2 = givenAuthor("Title Lee");

        book1.setAuthors(Lists.newArrayList(author1));
        book2.setAuthors(Lists.newArrayList(author2));
        book3.setAuthors(Lists.newArrayList(author1, author2));
        book4.setAuthors(Lists.newArrayList(author1, author2));

        author1.setBooks(Lists.newArrayList(book1, book2, book3));
        author2.setBooks(Lists.newArrayList(book2, book3, book4));

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3, book4));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));

        bookRepository.findAll().forEach(System.out::println);
    }

    private Book givenBook(String name) {
        Book book = Book.builder()
                .name(name)
                .build();
        return bookRepository.save(book);
    }

    private Author givenAuthor(String name) {
        Author author = Author.builder()
                .name(name)
                .build();
        return authorRepository.save(author);
    }
}