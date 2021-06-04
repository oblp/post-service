package xyz.eastack.article.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.eastack.article.application.command.CreateArticleCommand;
import xyz.eastack.article.application.command.UpdateDraftCommand;
import xyz.eastack.article.application.representation.ArticleRepresentation;
import xyz.eastack.article.domain.article.Article;
import xyz.eastack.article.domain.article.ArticleId;
import xyz.eastack.article.domain.article.ArticleService;
import xyz.eastack.article.domain.article.AuthorId;
import xyz.eastack.article.domain.tag.TagId;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
@RequiredArgsConstructor
public class ArticleApplicationService {
    private final ArticleService articleService;

    public ArticleRepresentation createArticle(Integer authorId, CreateArticleCommand command) {
        Article article = new Article();
        Set<TagId> tags = command.getTagIds()
            .stream()
            .map(TagId::new)
            .collect(toSet());
        article.addAllTag(tags);
        article.setAuthor(new AuthorId(authorId));

        article = articleService.createArticle(article);
        return ArticleBeanMapper.INSTANCE.to(article);
    }

    public ArticleRepresentation articleDetail(Integer id) {
        return new ArticleRepresentation();
    }

    public void deleteArticle(Integer id) {
        articleService.deleteArticle(new ArticleId(id));
    }

    public Void updateRaft(Integer userId, UpdateDraftCommand command) {
        return null;
    }

    public ArticleRepresentation publish(Integer articleId) {
        return null;
    }
}
