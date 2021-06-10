package cn.eastack.article.domain.article;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private Integer id;
    private String name;
}
