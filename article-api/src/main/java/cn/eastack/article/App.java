package cn.eastack.article;

import cn.eastack.article.adapter.inbound.rest.ArticleVerticle;
import com.google.inject.Guice;
import io.vertx.core.Vertx;

public class App {
    public static void main(String[] args) {
        ArticleVerticle articleVerticle = Guice.createInjector().getInstance(ArticleVerticle.class);
        Vertx.vertx().deployVerticle(articleVerticle);
    }
}
