package cn.eastack.article.adapter.inbound.grpc;

import cn.eastack.user.grpc.User;
import cn.eastack.user.grpc.UserServiceGrpc;

public class UserGateway {
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public User.UserInfo getUserInfo() {
        User.GetUserInfoRequest getUserInfoRequest = User.GetUserInfoRequest.newBuilder().setUserId(1).build();
        return userServiceBlockingStub.getUserInfo(getUserInfoRequest);
    }
}
