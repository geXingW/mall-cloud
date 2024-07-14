package com.gexingw.mall.auth;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.gexingw.mall.auth.starter.MallAuthApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 15:59
 */
@SpringBootTest(classes = MallAuthApplication.class)
public class OAuth2RegisteredClientModelTest {

    @Resource
    private RegisteredClientRepository registeredClientRepository;

    @Test
    public void testSave() {
        String clientId = RandomUtil.randomString(15);
        System.out.println(clientId);
        String clientSecret = RandomUtil.randomString(30);
        System.out.println(clientSecret);

        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId(clientId)
                .clientSecret("{bcrypt}" + new BCryptPasswordEncoder().encode(clientSecret))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .scope("mall")
                .redirectUri("https://mall-cloud.com")
                .tokenSettings(TokenSettings.builder().accessTokenFormat(OAuth2TokenFormat.REFERENCE).accessTokenTimeToLive(Duration.ofMinutes(10)).build())
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(false).build())
                .build();
        registeredClientRepository.save(registeredClient);
    }

}
