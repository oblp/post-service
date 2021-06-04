package xyz.eastack.article.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import xyz.eastack.article.application.representation.ArticleRepresentation;
import xyz.eastack.article.domain.article.Article;

public interface ArticleBeanMapper {
    ArticleBeanMapper INSTANCE = Mappers.getMapper(ArticleBeanMapper.class);

    ArticleRepresentation to(Article article);
}
