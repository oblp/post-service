package cn.eastack.article.domain.article;

import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;

@Singleton
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ArticleService {
    public Article createArticle(Article article) {
        article.setStatus(ArticleStatus.Created);
        return article;
    }
}
