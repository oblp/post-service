package cn.eastack.article.domain.article;

import lombok.Data;
import cn.eastack.article.domain.tag.TagId;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Article {
    private String title;
    private String content;
    private ArticleId id;
    private AuthorId authorId;
    private Author author;
    private Set<TagId> tags;
    private ArticleStatus status;
    private ArticleVisibility visibility;
    private LocalDateTime publishTime;

    public void publish() {
        if (!ArticleStatus.Created.equals(status)) return;

        publishTime = LocalDateTime.now();
        status = ArticleStatus.Published;
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
