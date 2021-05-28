package me.eastack.oblp.article.domain.converter;

import me.eastack.oblp.article.domain.entity.Article;
import me.eastack.oblp.article.infrastructure.ArticleDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleConverter {
    ArticleConverter INSTANCE = Mappers.getMapper(ArticleConverter.class);

    @Mapping(source = "title", target = "title")
    Article fromArticleDO(ArticleDO articleDO);
}
