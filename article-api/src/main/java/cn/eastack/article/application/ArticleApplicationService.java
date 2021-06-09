package cn.eastack.article.application;

import cn.eastack.article.application.command.CreateArticleCommand;
import cn.eastack.article.application.command.UpdateDraftCommand;
import cn.eastack.article.application.representation.ArticleRepresentation;
import cn.eastack.article.domain.article.Article;
import cn.eastack.article.domain.article.ArticleService;
import com.google.inject.Inject;

import javax.inject.Singleton;

@Singleton
public class ArticleApplicationService {
    @Inject
    private ArticleService articleService;

    public ArticleRepresentation createArticle(Integer authorId, CreateArticleCommand command) {
        Article article = new Article();
        article = articleService.createArticle(article);
        return ArticleBeanMapper.INSTANCE.toR(article);
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
