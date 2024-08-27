package com.gexingw.mall.user.infra.repository;

import com.gexingw.mall.user.domain.auth.AuthToken;
import com.gexingw.mall.user.domain.auth.AuthUser;
import com.gexingw.mall.user.domain.auth.AuthUserRepository;
import com.gexingw.mall.user.infra.config.AuthClientConfig;
import com.gexingw.mall.user.infra.rpc.auth.AuthUserRPCClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/12 13:28
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserRepositoryImpl implements AuthUserRepository {

    private final AuthClientConfig authClientConfig;

    private final AuthUserRPCClient authUserRPCClient;

    @Override
    public Long register(AuthUser authUser) {
        // 向认证中心注册用户信息
        return authUserRPCClient.registerUser(authUser.getPhone(), authUser.getPassword());
    }

    @Override
    public AuthToken login(String phone, String password) {
        return authUserRPCClient.loginUser(phone, password);
    }

    @Override
    public void logout(String accessToken) {
        authUserRPCClient.logout(accessToken);
    }

}
