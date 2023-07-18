package com.example.practice.practice5.jpa.repository;

import com.example.practice.practice5.jpa.model.Book;
import com.example.practice.practice5.jpa.model.Somthing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b.id ids, b.name text1 from Book b where b.id = ?1")
    List<Somthing> selectBySome(Long id);

    @Query(value = """
            SELECT
                b.id ids,
                b.name text1,
                p.name text2
            FROM book b
            INNER JOIN publisher p on p.id = b.publisher_id
            WHERE p.id = :id
            """, nativeQuery = true)
    List<Somthing> selectByNativeSome(Long id);

    @Transactional
    @Modifying
    @Query(value = """
        update 
            Book
        set 
            name = '이상한자바책' 
        where 
            id = :id
        """)
    int updateSpecificNameByJPQL(@Param("id") Long id);

}
