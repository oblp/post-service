package cn.eastack.article.domain.article;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleConverter {
    ArticleConverter INSTANCE = Mappers.getMapper(ArticleConverter.class);

    @Mapping(source = "title", target = "title")
    Article fromArticleDo(Article articleDo);
}
