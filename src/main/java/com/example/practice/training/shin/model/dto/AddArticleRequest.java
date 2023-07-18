package com.example.practice.training.shin.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;
}
