package com.example.practice.training.shin.model.dto;

import com.example.practice.training.shin.model.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
