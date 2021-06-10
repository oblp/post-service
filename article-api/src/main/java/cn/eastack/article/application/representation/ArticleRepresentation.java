package cn.eastack.article.application.representation;

import lombok.Data;

@Data
public class ArticleRepresentation {
    private String title;
    private String author;
    private String content;
}
