package com.gexingw.mall.user.infra.repository;

import com.gexingw.mall.auth.client.co.AuthUserCO;
import com.gexingw.mall.auth.client.co.TokenInfoCO;
import com.gexingw.mall.auth.client.command.PasswordLoginCommand;
import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.auth.client.rpc.AuthUserRPCClient;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.web.util.HttpRequestUtil;
import com.gexingw.mall.user.domain.auth.AuthToken;
import com.gexingw.mall.user.domain.auth.AuthUser;
import com.gexingw.mall.user.domain.auth.AuthUserRepository;
import com.gexingw.mall.user.infra.config.AuthClientConfig;
import com.gexingw.mall.user.infra.convert.AuthUserConvert;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
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

    @DubboReference(timeout = -1)
    private AuthUserRPCClient authUserRPCClient;

    @Override
    public Long register(AuthUser authUser) {
        R<Long> registerResult = authUserRPCClient.register(new UserRegisterCommand(authUser.getPhone(), authUser.getPassword(), authUser.getPhone()));
        if (!registerResult.isSuccess()) {
            throw new RuntimeException("注册失败！");
        }

        return registerResult.getData();
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

    @Override
    public AuthUser findByPhone(String phone) {
        R<AuthUserCO> findResult = authUserRPCClient.findByPhone(phone);
        if (!findResult.isSuccess()) {
            return null;
        }

        return AuthUserConvert.INSTANCE.toDomain(findResult.getData());
    }

}
