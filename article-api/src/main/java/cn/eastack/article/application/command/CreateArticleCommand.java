package cn.eastack.article.application.command;

import lombok.Data;
import java.time.Instant;
import java.util.Set;

@Data
public class CreateArticleCommand {
    private String coverId;
    private String title;
    private String content;
    private String summary;
    private Integer authorId;
    private Instant createTime;
    private Set<Integer> tagIds;
    private Boolean privacy;
}
