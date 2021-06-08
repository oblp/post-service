package cn.eastack.article.application.representation;

import lombok.Data;

@Data
public class ArticleRepresentation {
    private Integer id;
    private String title;
    private String content;
}
