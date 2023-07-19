package com.example.practice.training.shin.repository;

import com.example.practice.training.shin.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}

