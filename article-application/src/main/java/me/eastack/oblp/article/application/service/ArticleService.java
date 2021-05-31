package me.eastack.oblp.article.application.service;

import lombok.RequiredArgsConstructor;
import me.eastack.oblp.article.application.command.CreateArticleCommand;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    public  createArticle(CreateArticleCommand command) {
        return 1;
    }
}
