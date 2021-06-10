package cn.eastack.article.application;

import cn.eastack.article.application.command.CreateArticleCommand;
import cn.eastack.article.application.command.UpdateDraftCommand;
import cn.eastack.article.application.representation.ArticleRepresentation;
import cn.eastack.article.domain.article.Article;
import cn.eastack.article.domain.article.ArticleService;
import cn.eastack.article.domain.article.Author;
import cn.eastack.article.domain.user.UserService;
import cn.eastack.article.domain.user.UserVo;
import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ArticleApplicationService {
    private final ArticleService articleService;
    private final UserService userService;

    public ArticleRepresentation createArticle(Integer authorId, CreateArticleCommand command) {
        Article article = new Article();

        UserVo userInfo = userService.getUserInfo(authorId);
        article.setAuthor(new Author(userInfo.getId(), userInfo.getName()));

        article.setTitle(command.getTitle());
        article.setContent(command.getContent());

        article = articleService.createArticle(article);

        ArticleRepresentation articleRepresentation = new ArticleRepresentation();
        articleRepresentation.setAuthor(article.getAuthor().getName());
        articleRepresentation.setTitle(article.getTitle());
        articleRepresentation.setContent(article.getContent());

        return articleRepresentation;
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
