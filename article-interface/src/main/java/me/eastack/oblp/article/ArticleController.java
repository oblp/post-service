package me.eastack.oblp.article;

import lombok.RequiredArgsConstructor;
import me.eastack.oblp.article.application.command.NewArticleCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Component
public class ArticleController {

    @PostMapping
    public Mono<NewArticleCommand> publish(@RequestBody @Validated NewArticleCommand newArticleCommand) {
        return Mono.just(newArticleCommand);
    }

    @GetMapping("/{id:\\d+}")
    public Mono<String> get(@PathVariable("id") Integer id) {
        return Mono.just("ID: " + id.toString());
    }
}
