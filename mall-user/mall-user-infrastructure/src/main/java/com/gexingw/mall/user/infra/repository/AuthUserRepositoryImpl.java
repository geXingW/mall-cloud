package com.gexingw.mall.user.infra.repository;

import com.gexingw.mall.auth.client.co.TokenInfoCO;
import com.gexingw.mall.auth.client.command.PasswordLoginCommand;
import com.gexingw.mall.common.web.util.HttpRequestUtil;
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
        // 调用认证授权中心，获取Token信息
        PasswordLoginCommand authLoginCommand = new PasswordLoginCommand();
        authLoginCommand.withClient(authClientConfig.getMall().getClientId(), authClientConfig.getMall().getClientSecret());
        authLoginCommand.withCredential(phone, password);

        TokenInfoCO tokenInfoCO = HttpRequestUtil.postJson("http://localhost:8001/oauth2/token", authLoginCommand, TokenInfoCO.class);
        if (tokenInfoCO == null) {
            return null;
        }

        return new AuthToken(tokenInfoCO.getAccessToken(), tokenInfoCO.getRefreshToken(), tokenInfoCO.getTokenType(), tokenInfoCO.getScope(), tokenInfoCO.getExpiresIn());
    }

}
