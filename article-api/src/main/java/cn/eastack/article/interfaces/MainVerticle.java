package cn.eastack.article.interfaces;

import cn.eastack.user.grpc.User;
import cn.eastack.user.grpc.VertxUserServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.grpc.VertxChannelBuilder;
import io.vertx.grpc.VertxServerBuilder;

import java.io.IOException;

public class MainVerticle extends AbstractVerticle {
    @Override
    public void start() throws IOException {
//        Router router = Router.router(vertx);
//        router.route().handler(context -> {
//            // Get the address of the request
//            String address = context.request().connection().remoteAddress().toString();
//            // Get the query parameter "name"
//            MultiMap queryParams = context.queryParams();
//            String name = queryParams.contains("name") ? queryParams.get("name") : "unknown";
//            // Write a json response
//            context.json(
//                new JsonObject()
//                    .put("name", name)
//                    .put("address", address)
//                    .put("message", "Hello " + name + " connected from " + address)
//            );
//        });

//        VertxUserServiceGrpc.UserServiceVertxImplBase service = new VertxUserServiceGrpc.UserServiceVertxImplBase() {
//            @Override
//            public Future<User.UserInfo> getUserInfo(User.GetUserInfoRequest request) {
//                return Future.succeededFuture(
//                    User.UserInfo.newBuilder()
//                        .setUserId(request.getUserId())
//                        .build());
//            }
//
//            @Override
//            public Future<Empty> addPoints(User.AddPointRequest request) {
//                return super.addPoints(request);
//            }
//        }.withCompression("gzip");
//
//        VertxServerBuilder
//            .forAddress(vertx, "localhost", 8080)
//            .addService(service)
//            .build().start();

//        vertx.createHttpServer()
//            .requestHandler(router)
//            .listen(8888)
//            .onSuccess(server -> System.out.println("HTTP server started on port 8888"));

        Router clientRouter = Router.router(vertx);
        clientRouter.route().handler(context -> {
            MultiMap queryParams = context.queryParams();
            String userIdStr = queryParams.contains("userId") ? queryParams.get("userId") : "1";
            int userId = Integer.parseInt(userIdStr);

            ManagedChannel channel = VertxChannelBuilder
                .forAddress(vertx ,"localhost", 50051)
                .usePlaintext()
                .build();

            // Get a stub to use for interacting with the remote service
            VertxUserServiceGrpc.UserServiceVertxStub stub = VertxUserServiceGrpc.newVertxStub(channel);

            User.GetUserInfoRequest request = User.GetUserInfoRequest.newBuilder().setUserId(2).build();

            // Call the remote service
            Future<User.UserInfo> future = stub.getUserInfo(request);

            // Listen to completion events
            future.onSuccess(userInfo -> {
                System.out.println("Got the server response: " + userInfo.getUserName());
                // Write a json response
                context.json(
                    new JsonObject()
                        .put("name", userInfo.getUserName())
                );
            }).onFailure(err -> System.out.println("Coult not reach server " + err));
        });

        vertx.createHttpServer()
            .requestHandler(clientRouter)
            .listen(9999)
            .onSuccess(server -> System.out.println("HTTP server started on port 9999"));
    }
}
