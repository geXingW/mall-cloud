package com.gexingw.mall.auth.infrastucture;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/16 13:49
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OAuth2RegisteredClientModelTest {

    private final RegisteredClientRepository registeredClientRepository;

    @Test
    public void testGenerateClient() {
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
    }

}
