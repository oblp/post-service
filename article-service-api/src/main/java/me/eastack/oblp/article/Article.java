package me.eastack.oblp.article;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Integer authorId;
    private String content;
}
