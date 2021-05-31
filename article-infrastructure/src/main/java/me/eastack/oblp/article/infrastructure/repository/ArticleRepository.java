package me.eastack.oblp.article.infrastructure.repository;

import me.eastack.oblp.article.infrastructure.ArticleDO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<ArticleDO, Integer> {
}
