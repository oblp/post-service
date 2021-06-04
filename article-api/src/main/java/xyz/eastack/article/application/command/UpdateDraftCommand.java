package xyz.eastack.article.application.command;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Accessors(fluent = true)
public class UpdateDraftCommand {
    @NotNull
    @Size(min = 1, max = 1024)
    private String coverId;
    private String title;
    private String content;
    private String summary;
    private Set<Integer> tagIds;
    private Boolean privacy;
}
