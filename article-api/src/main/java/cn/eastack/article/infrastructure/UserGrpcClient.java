package cn.eastack.article.infrastructure;


import cn.eastack.user.grpc.User;
import cn.eastack.user.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;

public class UserGrpcClient {
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;
    private final ManagedChannel channel;

    public UserGrpcClient(ManagedChannel channel) {
        this.channel = channel;
        this.blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public void test() {
        User.GetUserInfoRequest getUserInfoRequest = User.GetUserInfoRequest.newBuilder().setUserId(1).build();
        User.UserInfo response;
    }
}
