package xyz.eastack.article.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import xyz.eastack.article.application.ArticleApplicationService;
import xyz.eastack.article.application.command.CreateArticleCommand;
import xyz.eastack.article.application.command.UpdateDraftCommand;
import xyz.eastack.article.application.representation.ArticleRepresentation;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Component
public class ArticleController {
    private final ArticleApplicationService articleService;
    private static final String articleIdName = "articleId";
    private static final String articleId = "/{" + articleIdName + ":\\d+}";

    @PostMapping
    public Mono<ArticleRepresentation> create(@RequestBody
                                              @Validated Mono<CreateArticleCommand> createArticleCommandMono) {
        // todo get from spring security context
        Integer userId = 101;

        return createArticleCommandMono
            .map(command -> articleService.createArticle(userId, command));
    }

    @GetMapping("/{id:\\d+}")
    public Mono<ArticleRepresentation> getArticle(@PathVariable("id") Mono<Integer> articleId) {
        return articleId.map(articleService::articleDetail);
    }

    @PatchMapping("/{id:\\d+}/draft")
    public Mono<Void> updateDraft(@PathVariable("id") Mono<Integer> id,
                                  @RequestBody
                                  @Validated Mono<UpdateDraftCommand> updateDraftCommandMono) {
        // todo get from spring security context
        Integer userId = 101;

        return updateDraftCommandMono.map(command -> articleService.updateRaft(userId, command));
    }

    @PutMapping("/{id:\\d+}/publish")
    public Mono<ArticleRepresentation> publish(@PathVariable("id") Mono<Integer> articleId) {
        return articleId.map(articleService::publish);
    }
}
