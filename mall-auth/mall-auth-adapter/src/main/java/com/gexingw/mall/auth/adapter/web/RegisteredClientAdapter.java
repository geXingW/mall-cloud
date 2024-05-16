package com.gexingw.mall.auth.adapter.web;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import com.gexingw.mall.common.core.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/16 15:33
 */
@RestController
@RequestMapping("/web/registered-client")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class RegisteredClientAdapter {

    private final RegisteredClientRepository registeredClientRepository;

    @PostMapping
    public R<Object> create() {
        System.out.println("client info:");
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
        return R.ok();
    }

}
