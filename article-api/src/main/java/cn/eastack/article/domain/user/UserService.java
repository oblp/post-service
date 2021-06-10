package cn.eastack.article.domain.user;

import cn.eastack.article.adapter.rpc.UserServiceStub;
import cn.eastack.user.grpc.User;

public class UserService {
    public UserVo getUserInfo(Integer userId) {
        User.GetUserInfoRequest getUserInfoRequest = User.GetUserInfoRequest.newBuilder().setUserId(userId).build();

        User.UserInfo userInfo = UserServiceStub.getUserInfo(getUserInfoRequest);

        UserVo userVo = new UserVo();
        userVo.setName(userInfo.getUserName());
        userVo.setId(userInfo.getUserId());

        return userVo;
    }
}
