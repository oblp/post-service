package cn.eastack.article.application.command;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(fluent = true)
public class UpdateDraftCommand {
    private String coverId;
    private String title;
    private String content;
    private String summary;
    private Set<Integer> tagIds;
    private Boolean privacy;
}
