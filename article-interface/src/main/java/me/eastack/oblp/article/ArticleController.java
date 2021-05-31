package me.eastack.oblp.article;

import lombok.RequiredArgsConstructor;
import me.eastack.oblp.article.application.command.CreateArticleCommand;
import me.eastack.oblp.article.application.service.ArticleService;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Component
public class ArticleController {
    private ArticleService articleService;

    @PostMapping
    public Mono<CreateArticleCommand> create(@RequestBody @Validated Mono<CreateArticleCommand> newArticleCommand) {
        return newArticleCommand.map(articleService::createArticle);
    }

    @GetMapping("/{id:\\d+}")
    public Mono<String> get(@PathVariable("id") Integer id) {
        return Mono.just("ID: " + id.toString());
    }
}
