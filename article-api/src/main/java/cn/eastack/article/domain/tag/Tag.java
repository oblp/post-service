package cn.eastack.article.domain.tag;

import cn.eastack.article.domain.article.Author;
import lombok.Data;

@Data
public class Tag {
    private Integer id;
    private String title;
    private String content;
    private Author author;
}
