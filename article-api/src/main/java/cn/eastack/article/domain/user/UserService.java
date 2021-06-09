package cn.eastack.article.domain.user;

import cn.eastack.article.adapter.outbound.grpc.UserGateway;
import cn.eastack.user.grpc.User;

public class UserService {
    public UserVo getUserInfo(Integer userId) {
        User.GetUserInfoRequest getUserInfoRequest = User.GetUserInfoRequest.newBuilder().setUserId(userId).build();

        User.UserInfo userInfo = UserGateway.getUserInfo(getUserInfoRequest);

        UserVo userVo = new UserVo();
        userVo.setName(userInfo.getUserName());
        userVo.setId(userInfo.getUserId());

        return userVo;
    }
}
