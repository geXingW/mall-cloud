package com.gexingw.mall.user.domain.user;

import com.gexingw.mall.user.domain.auth.AuthToken;
import com.gexingw.mall.user.domain.auth.AuthUser;
import com.gexingw.mall.user.domain.auth.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/14 10:13
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserDomainService {

    private final AuthUserRepository authUserRepository;
    private final UserRepository userRepository;

    public AuthToken login(String phone, String password) {
        // 检查用户是否存在
        User existUser = userRepository.findByPhone(phone);
        if (existUser != null) {
            // 用户存在直接调用登录
            // 调用认证授权中心，获取Token信息
            return authUserRepository.login(phone, password);
        }

        // 创建认证中心用户
        AuthUser registerAuthUser = new AuthUser(new Nickname().getValue(), phone, password);
        Long registeredAuthUserId = authUserRepository.register(registerAuthUser);
        // 创建业务系统用户
        userRepository.save(new User(registeredAuthUserId, phone));

        // 获取用户Token信息
        return authUserRepository.login(phone, password);
    }

    public void logout(@NotNull String accessToken) {
        authUserRepository.logout(accessToken);
    }

}
