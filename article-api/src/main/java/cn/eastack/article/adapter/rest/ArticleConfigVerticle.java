package cn.eastack.article.adapter.rest;

import com.google.inject.Guice;
import io.vertx.core.AbstractVerticle;

public class ArticleConfigVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

        ArticleApiVerticle articleApiVerticle = Guice.createInjector()
            .getInstance(ArticleApiVerticle.class);

        vertx.deployVerticle(articleApiVerticle);
    }
}
