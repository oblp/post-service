package me.eastack.oblp.article;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document;
import static org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.documentationConfiguration;

@ExtendWith(RestDocumentationExtension.class)
class ArticleControllerTest extends ApplicationTests {
    private WebTestClient webTestClient;

    @BeforeEach
    public void setUp(ApplicationContext applicationContext,
                      RestDocumentationContextProvider restDocument) {
        this.webTestClient = WebTestClient.bindToApplicationContext(applicationContext)
            .configureClient()
            .filter(documentationConfiguration(restDocument))
            .build();
    }

    @Test
    void publish() {

    }

    @Test
    void get() {
        this.webTestClient.get()
            .uri("/articles/1").exchange()
            .expectStatus().isOk()
            .expectBody().consumeWith(document("sample"));
    }
}
