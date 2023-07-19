package com.example.practice.training.shin.controller;

import com.example.practice.training.shin.model.dto.AddArticleRequest;
import com.example.practice.training.shin.repository.ArticleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ArticleApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper om;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    void addArticle() throws Exception {
        // 1. give
        // given
        final String url = "/api/articles";
        final String title = "제목";
        final String content = "내용";
//        final AddArticleRequest userRequest = new AddArticleRequest(title, content);
        final AddArticleRequest userRequest = AddArticleRequest.builder()
                .title(title)
                .content(content)
                .build();
        final String requestBody = om.writeValueAsString(userRequest);  // java class를 json string형태로 바꾸어줌

        // 2. when
        ResultActions resultActions = mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody));

        // 3. then
    }
}