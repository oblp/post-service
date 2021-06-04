package xyz.eastack.article.domain.article;

import lombok.Data;
import xyz.eastack.article.domain.tag.TagId;

import javax.persistence.Embedded;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Article {
    private String title;
    private String content;
    @Embedded private ArticleId id;
    @Embedded private AuthorId author;
    private Set<TagId> tags;
    private ArticleStatus status;
    private ArticleVisibility visibility;
    private LocalDateTime publishTime;

    public void publish() {
        if (!ArticleStatus.CREATED.equals(status)) return;

        publishTime = LocalDateTime.now();
        status = ArticleStatus.PUBLISHED;
    }

    public void addTag(TagId tag) {
        tags.add(tag);
    }

    public void addAllTag(Set<TagId> tags) {
        tags.forEach(this::addTag);
    }

    public void deleteTag(TagId tag) {
        tags.remove(tag);
    }

    public void makePublic() {
        if (ArticleVisibility.PUBLIC.equals(visibility)) return;
        this.visibility = ArticleVisibility.PUBLIC;
    }

    public void makePrivate() {
        if (ArticleVisibility.PRIVATE.equals(visibility)) return;
        this.visibility = ArticleVisibility.PRIVATE;
    }
}
