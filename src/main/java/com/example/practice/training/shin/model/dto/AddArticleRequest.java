package com.example.practice.training.shin.model.dto;

import com.example.practice.training.shin.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        System.out.println("⭕");
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
