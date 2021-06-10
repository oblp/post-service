package cn.eastack.article.adapter.rpc;

import cn.eastack.user.grpc.User;
import cn.eastack.user.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.vertx.grpc.VertxChannelBuilder;

public class UserServiceStub {
    private static final String USER_GRPC_ADDRESS = "localhost:50051";
    private static final ManagedChannel CHANNEL = VertxChannelBuilder
        .forTarget(USER_GRPC_ADDRESS)
        .usePlaintext()
        .build();
    private static final UserServiceGrpc.UserServiceBlockingStub STUB = UserServiceGrpc.newBlockingStub(CHANNEL);

    public static User.UserInfo getUserInfo(User.GetUserInfoRequest getUserInfoRequest) {
        return STUB.getUserInfo(getUserInfoRequest);
    }
}
