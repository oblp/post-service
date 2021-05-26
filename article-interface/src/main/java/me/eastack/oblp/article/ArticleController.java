package me.eastack.oblp.article;

import lombok.RequiredArgsConstructor;
import me.eastack.oblp.article.application.dto.command.NewArticleCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Component
public class ArticleController {

    @GetMapping("/classpath")
    public Mono<String> publish(@Validated NewArticleCommand newArticleCommand) {
        return Mono.empty();
    }

    @GetMapping("/{id:\\d+}")
    public Mono<String> get(@PathVariable("id") Integer id) {
        return Mono.just("ID: " + id.toString());
    }
}
