package xyz.eastack.article.domain.article;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface ArticleRepository extends ReactiveSortingRepository<Article, ArticleId> {
}
