package com.gexingw.mall.auth.application.command.client;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import com.gexingw.mall.auth.application.assembler.RegisteredClientAssembler;
import com.gexingw.mall.auth.application.vo.RegisteredClientCreateResultVO;
import com.gexingw.mall.auth.infrastructure.component.DbOAuth2RegisteredClientRepository;
import com.gexingw.mall.common.core.support.ICommand;
import com.gexingw.mall.common.spring.command.CommandHandler;
import com.gexingw.mall.common.spring.command.ICommandExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 22:58
 */
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@CommandHandler(RegisteredClientAddCmd.class)
public class RegisteredClientAddCmdExecutor implements ICommandExecutor {

    private final DbOAuth2RegisteredClientRepository registeredClientRepository;

    private final RegisteredClientAssembler registeredClientAssembler;

    @Override
    public RegisteredClientCreateResultVO handleWithResult(ICommand command) {
        RegisteredClientAddCmd addCmd = (RegisteredClientAddCmd) command;

        String clientId = RandomUtil.randomString(15);
        System.out.println(clientId);
        String clientSecret = RandomUtil.randomString(30);
        System.out.println(clientSecret);

        TokenSettings tokenSettings = TokenSettings.builder().accessTokenFormat(OAuth2TokenFormat.REFERENCE).accessTokenTimeToLive(Duration.ofHours(24))
                .refreshTokenTimeToLive(Duration.ofHours(5)).build();

        RegisteredClient registeredClient = RegisteredClient.withId(LocalDateTimeUtil.format(LocalDateTimeUtil.now(), "yyyyMMddHHmmssSSS"))
                .clientId(clientId)
                .clientSecret("{bcrypt}" + new BCryptPasswordEncoder().encode(clientSecret))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .scope("oidc")
                .tokenSettings(tokenSettings)
                .redirectUri("www.baidu.com").build();
        registeredClientRepository.save(registeredClient);

        return registeredClientAssembler.toCreateResultVO(registeredClient);
    }

}
