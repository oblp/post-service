package cn.eastack.article.application;

import cn.eastack.article.application.command.CreateArticleCommand;
import cn.eastack.article.domain.article.Article;
import lombok.RequiredArgsConstructor;
import cn.eastack.article.application.command.UpdateDraftCommand;
import cn.eastack.article.application.representation.ArticleRepresentation;
import cn.eastack.article.domain.article.ArticleId;
import cn.eastack.article.domain.article.ArticleService;
import cn.eastack.article.domain.article.AuthorId;
import cn.eastack.article.domain.tag.TagId;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

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
    }

    public Void updateRaft(Integer userId, UpdateDraftCommand command) {
        return null;
    }

    public ArticleRepresentation publish(Integer articleId) {
        return null;
    }
}
