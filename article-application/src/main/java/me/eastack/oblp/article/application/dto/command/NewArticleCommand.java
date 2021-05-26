package me.eastack.oblp.article.application.dto.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewArticleCommand {
    @NotNull
    @Size(min = 1, max = 64)
    private String title;
    private String content;
}
