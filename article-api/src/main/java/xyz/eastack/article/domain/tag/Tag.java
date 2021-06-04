package xyz.eastack.article.domain.tag;

import lombok.Data;
import xyz.eastack.article.domain.article.Author;

@Data
public class Tag {
    private Integer id;
    private String title;
    private String content;
    private Author author;
}
