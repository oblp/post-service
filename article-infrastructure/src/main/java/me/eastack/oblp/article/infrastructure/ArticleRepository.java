package me.eastack.oblp.article.infrastructure;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<ArticleDO, Integer> {
}
