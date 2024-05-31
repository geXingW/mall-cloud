package com.gexingw.mall.account.application.command.auth;

import cn.hutool.core.bean.BeanUtil;
import com.gexingw.mall.account.application.dto.auth.PasswdLoginResponse;
import com.gexingw.mall.account.application.vo.auth.AuthTokenVO;
import com.gexingw.mall.account.infrastructure.config.AuthClientConfig;
import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import com.gexingw.mall.common.web.util.HttpRequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.Map;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 14:32
 */
@CommandHandler(MallUsernamePasswdLoginCmd.class)
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MallUsernamePasswdLoginCmdExecutor implements ICommandExecutor {

    private final AuthClientConfig authClientConfig;

    @Override
    public AuthTokenVO handleWithResult(ICommand command) {
        MallUsernamePasswdLoginCmd loginCmd = (MallUsernamePasswdLoginCmd) command;
        AuthPasswdGrantTypeCmd authCmd = new AuthPasswdGrantTypeCmd(authClientConfig.getMall());
        authCmd.setUsername(loginCmd.getUsername()).setPassword(loginCmd.getPassword());

        // 调用认证授权中心，获取Token信息
        //noinspection VulnerableCodeUsages
        Map<String, Object> requestParams = BeanUtil.beanToMap(authCmd, true, false);
        PasswdLoginResponse loginResponse = HttpRequestUtil.postJson("http://localhost:8001/oauth2/token", requestParams, PasswdLoginResponse.class);
        if (loginResponse == null) {
            throw new RuntimeException("登录异常！");
        }

        return new AuthTokenVO(loginResponse.getAccessToken(), loginResponse.getRefreshToken(), loginResponse.getScope(), loginResponse.getTokenType(), loginResponse.getExpiresIn());
    }

}
