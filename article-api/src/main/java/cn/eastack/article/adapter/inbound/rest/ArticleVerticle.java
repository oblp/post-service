package cn.eastack.article.adapter.inbound.rest;

import cn.eastack.article.application.ArticleApplicationService;
import cn.eastack.article.application.command.CreateArticleCommand;
import cn.eastack.article.domain.article.ArticleService;
import cn.eastack.article.domain.user.UserService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import lombok.RequiredArgsConstructor;

@Singleton
public class ArticleVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleVerticle.class);
    private static final String ARTICLE = "/articles";
    private static final Integer PORT = 9999;
    @Inject
    private ArticleApplicationService articleApplicationService;

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.post().handler(BodyHandler.create());
        router.post(ARTICLE).handler(this::create);
        router.get(ARTICLE).handler(this::list);
        router.get(ARTICLE + "/:articleId").handler(this::detail);

        vertx.createHttpServer()
            .requestHandler(router)
            .listen(PORT)
            .onSuccess(server -> System.out.println("HTTP server started on port " + PORT));
    }

    public void list(RoutingContext ctx) {
        MultiMap queryParams = ctx.queryParams();
        String userIdStr = queryParams.contains("userId") ? queryParams.get("userId") : "1";
        int userId = Integer.parseInt(userIdStr);

        ctx.json(new JsonObject().put("name", userId));
    }

    public void detail(RoutingContext ctx) {
        Integer articleId = Integer.parseInt(ctx.pathParam("articleId"));
        ctx.json(new JsonObject()
            .put("name", "Bob"));
    }

    public void create(RoutingContext ctx) {
        CreateArticleCommand createArticleCommand = new CreateArticleCommand();
        ctx.json(articleApplicationService.createArticle(1, createArticleCommand))
            .onFailure(err -> {
                LOGGER.error(err.getMessage());
                err.printStackTrace();
            });
    }
}
