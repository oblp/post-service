package xyz.eastack.article.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/about")
@RequiredArgsConstructor
public class AboutController {
    private final BuildProperties buildProperties;

    @GetMapping
    public Mono<BuildProperties> about() {
        return Mono.just(buildProperties);
    }
}
