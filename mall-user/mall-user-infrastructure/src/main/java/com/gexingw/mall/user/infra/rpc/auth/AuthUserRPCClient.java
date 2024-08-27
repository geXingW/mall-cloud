package com.gexingw.mall.user.infra.rpc.auth;

import com.gexingw.mall.auth.client.co.TokenInfoCO;
import com.gexingw.mall.auth.client.command.PasswordLoginCommand;
import com.gexingw.mall.auth.client.command.user.UserRegisterCommand;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.web.util.HttpRequestUtil;
import com.gexingw.mall.user.domain.auth.AuthToken;
import com.gexingw.mall.user.infra.config.AuthClientConfig;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 15:15
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthUserRPCClient {

    private final AuthClientConfig authClientConfig;

    @DubboReference
    private com.gexingw.mall.auth.client.rpc.AuthUserRPCClient authUserRPCClient;

    /**
     * 注册用户
     *
     * @param phone    手机号
     * @param password 密码
     * @return 新用户Id
     */
    public Long registerUser(String phone, String password) {
        R<Long> registerResult = authUserRPCClient.register(new UserRegisterCommand(phone, password, phone));
        if (!registerResult.isSuccess()) {
            throw new RuntimeException("注册失败！");
        }

        return registerResult.getData();
    }

    public AuthToken loginUser(String phone, String password) {
        // 调用认证授权中心，获取Token信息
        PasswordLoginCommand authLoginCommand = new PasswordLoginCommand();
        authLoginCommand.withClient(authClientConfig.getMall().getClientId(), authClientConfig.getMall().getClientSecret());
        authLoginCommand.withCredential(phone, password);

        TokenInfoCO tokenInfoCO = HttpRequestUtil.postJson("http://localhost:8001/oauth2/token", authLoginCommand, TokenInfoCO.class);
        if (tokenInfoCO == null) {
            throw new RuntimeException("登录失败！");
        }

        return new AuthToken(
                tokenInfoCO.getAccessToken(), tokenInfoCO.getRefreshToken(), tokenInfoCO.getTokenType(), tokenInfoCO.getScope()
                , tokenInfoCO.getExpiresIn()
        );
    }

}