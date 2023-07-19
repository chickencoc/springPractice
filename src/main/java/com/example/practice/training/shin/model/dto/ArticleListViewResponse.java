package com.example.practice.training.shin.model.dto;

import com.example.practice.training.shin.model.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleListViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createAt = article.getCreateAt();
        this.updateAt = article.getUpdateAt();
    }
}
