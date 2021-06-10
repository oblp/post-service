package cn.eastack.article.adapter.rest;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class AboutConfigVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(AboutConfigVerticle.class);

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.post().handler(BodyHandler.create());

        router.get("/about").handler(this::about);

//        vertx.createHttpServer()
//            .requestHandler(router)
//            .listen(9999)
//            .onSuccess(server -> System.out.println("HTTP server started on port 9999"));
    }

    public void about(RoutingContext ctx) {
        ctx.json(new JsonObject().put("ok", "yes"));
    }
}
