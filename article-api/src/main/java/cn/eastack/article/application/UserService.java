package cn.eastack.article.application;

import cn.eastack.article.adapter.inbound.grpc.UserGateway;
import cn.eastack.article.domain.user.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserGateway userGateway;
//    public User getUserInfo() {
//
//    }
}
