package com.example.practice.training.shin.controller;

import com.example.practice.training.shin.model.Article;
import com.example.practice.training.shin.model.dto.ArticleListViewResponse;
import com.example.practice.training.shin.model.dto.ArticleResponse;
import com.example.practice.training.shin.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {

    private final ArticleService articleService;

    @GetMapping("/articles") // 메인
    public String getArticles(Model model) {

        List<ArticleListViewResponse> articleResponseList = articleService.getArticleAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articleResponseList);

//        model.addAttribute("articles", articleService.getArticleAll());

        return "articleList";
    }

    @GetMapping("/new-article")
    public String newArticles(Model model) {

        return "newArticle";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", new ArticleListViewResponse(article));

        return "article";
    }

}
