package cn.eastack.article.domain.article;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article createArticle(Article article) {
        article.setStatus(ArticleStatus.Created);
        return article;
    }
}
