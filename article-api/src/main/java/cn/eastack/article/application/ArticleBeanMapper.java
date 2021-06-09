package cn.eastack.article.application;

import cn.eastack.article.domain.article.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import cn.eastack.article.application.representation.ArticleRepresentation;

@Mapper
public interface ArticleBeanMapper {
    ArticleBeanMapper INSTANCE = Mappers.getMapper(ArticleBeanMapper.class);


    @Mapping(source = "title", target = "title")
    ArticleRepresentation toR(Article article);
}
