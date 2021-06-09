package cn.eastack.article.domain.article;

import cn.eastack.article.domain.user.UserService;
import cn.eastack.article.domain.user.UserVo;
import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;

@Singleton
public class ArticleService {
    public Article createArticle(Article article) {
        UserService userService = new UserService();
        article.setStatus(ArticleStatus.Created);

        UserVo userInfo = userService.getUserInfo(1);
        Author author = new Author();
        author.setId(userInfo.getId());
        author.setName(userInfo.getName());
        article.setAuthor(author);

        System.out.println(author);

        return article;
    }
}
