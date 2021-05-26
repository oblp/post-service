package me.eastack.oblp.article.application.service;

import lombok.RequiredArgsConstructor;
import me.eastack.oblp.article.application.dto.command.NewArticleCommand;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    public Integer newArticle(NewArticleCommand command) {
        return 1;
    }
}
