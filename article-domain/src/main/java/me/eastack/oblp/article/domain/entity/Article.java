package me.eastack.oblp.article.domain.entity;

import lombok.Data;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Author author;
}
