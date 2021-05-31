package me.eastack.oblp.article.application.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateArticleCommand {
    @NotNull
    @Size(min = 1, max = 1024)
    private String title;
    private String content;
    private String content;
}
