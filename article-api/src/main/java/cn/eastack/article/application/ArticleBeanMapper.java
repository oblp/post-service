package cn.eastack.article.application;

import cn.eastack.article.domain.article.Article;
import org.mapstruct.factory.Mappers;
import cn.eastack.article.application.representation.ArticleRepresentation;

public interface ArticleBeanMapper {
    ArticleBeanMapper INSTANCE = Mappers.getMapper(ArticleBeanMapper.class);

    ArticleRepresentation to(Article article);
}
