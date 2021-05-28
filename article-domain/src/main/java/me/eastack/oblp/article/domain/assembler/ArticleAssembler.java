package me.eastack.oblp.article.domain.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleAssembler {
    ArticleAssembler INSTANCE = Mappers.getMapper(ArticleAssembler.class);


}
