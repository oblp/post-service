package me.eastack.oblp.article;

import me.eastack.oblp.article.application.command.CreateArticleCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

class ArticleControllerTest extends ApplicationTests {
    private WebTestClient webTestClient;

    @BeforeEach
    public void setUp(ApplicationContext applicationContext) {
        this.webTestClient = WebTestClient
            .bindToApplicationContext(applicationContext)
            .configureClient()
            .build();
    }

    @Test
    void publish() {
        CreateArticleCommand createArticleCommand = new CreateArticleCommand();
        createArticleCommand.setTitle("Hello World");
        createArticleCommand.setContent("System.out.println(\"hello world\")");

        this.webTestClient
            .post().uri("/articles")
            .body(Mono.just(createArticleCommand), CreateArticleCommand.class).exchange()
            .expectStatus().isOk();
    }

    @Test
    void get() {
        this.webTestClient.get()
            .uri("/articles/1").exchange()
            .expectStatus().isOk();
    }
}
