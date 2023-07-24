package com.example.practice.training.shin.service;

import com.example.practice.training.shin.model.Article;
import com.example.practice.training.shin.model.dto.AddArticleRequest;
import com.example.practice.training.shin.model.dto.UpdateArticleRequest;
import com.example.practice.training.shin.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    // 블로그 글 저장
    public Article save(AddArticleRequest addArticleRequest, String author) {
        return articleRepository.save(addArticleRequest.toEntity(author));
    }

    // 블로그 글 목록 가져오기
    public List<Article> getArticleAll() {
        return articleRepository.findAll();
    }

    // 블로그 글 상세정보 가져오기
    public Article getArticle(long articleId) {
        return articleRepository.findById(articleId).orElseThrow(
                () -> new IllegalArgumentException("not found : " + articleId)
        );
    }

    // 블로그 글 삭제하기
    public void delete(long id) {
        articleRepository.deleteById(id);
    }

    // 블로그 글 수정하기
    public Article update(long articleId, UpdateArticleRequest updateArticleRequest) {

        Article article = articleRepository.findById(articleId).orElseThrow(
                () -> new IllegalArgumentException("not found : " + articleId));

//        article.setTitle(updateArticleRequest.getTitle());
//        article.setContent(updateArticleRequest.getContent());
        article.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());

        return articleRepository.save(article);    // update
    }

    public Article findById(long id) {
       return articleRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }
}
