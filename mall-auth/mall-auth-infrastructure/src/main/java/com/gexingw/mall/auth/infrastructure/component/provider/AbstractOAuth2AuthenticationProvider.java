package com.gexingw.mall.auth.infrastructure.component.provider;

import com.gexingw.mall.auth.infrastructure.dataobj.AuthUserDO;
import com.gexingw.mall.common.core.constant.OAuth2Constant;
import com.gexingw.mall.common.core.domain.AuthInfo;
import com.gexingw.mall.common.core.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.util.Assert;

import java.security.Principal;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 17:52
 */
@Slf4j
public abstract class AbstractOAuth2AuthenticationProvider implements AuthenticationProvider {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AbstractOAuth2AuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication clientAuthentication) throws AuthenticationException {
        OAuth2ClientAuthenticationToken clientPrincipal = (OAuth2ClientAuthenticationToken) clientAuthentication.getPrincipal();
        RegisteredClient registeredClient = clientPrincipal.getRegisteredClient();
        Assert.notNull(registeredClient, "RegisteredClient should not be null!");

        Authentication userAuthentication = this.getAuthentication(clientAuthentication, registeredClient);
        // AccessToken
        DefaultOAuth2TokenContext accessTokenContext = DefaultOAuth2TokenContext.builder().registeredClient(registeredClient)
                .principal(userAuthentication).tokenType(OAuth2TokenType.ACCESS_TOKEN).authorizedScopes(registeredClient.getScopes())
                .authorizationGrantType(new AuthorizationGrantType(this.grantType())).build();
        //noinspection unchecked
        OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator = SpringUtil.getBean(OAuth2TokenGenerator.class);
        OAuth2Token accessToken = tokenGenerator.generate(accessTokenContext);
        Assert.notNull(accessToken, "AccessToken should not be null!");

        OAuth2AccessToken oAuth2AccessToken = new OAuth2AccessToken(OAuth2AccessToken.TokenType.BEARER, accessToken.getTokenValue(), accessToken.getIssuedAt(), accessToken.getExpiresAt(), accessTokenContext.getAuthorizedScopes());
        OAuth2Authorization.Builder oAuth2AuthroizationBuilder = OAuth2Authorization.withRegisteredClient(registeredClient)
                .principalName(clientAuthentication.getName())
                .attribute(Principal.class.getName(), userAuthentication)
                .authorizedScopes(registeredClient.getScopes())
                .attribute(OAuth2Constant.TOKEN_SETTINGS, registeredClient.getTokenSettings())
                .authorizationGrantType(new AuthorizationGrantType(this.grantType()))
                .accessToken(oAuth2AccessToken);

        // 配置refreshToken，生成RefreshToken
        OAuth2RefreshToken oAuth2RefreshToken = null;
        if (registeredClient.getAuthorizationGrantTypes().contains(AuthorizationGrantType.REFRESH_TOKEN)) {
            DefaultOAuth2TokenContext.builder().registeredClient(registeredClient);

            DefaultOAuth2TokenContext refreshTokenContext = DefaultOAuth2TokenContext.builder().registeredClient(registeredClient)
                    .tokenType(OAuth2TokenType.REFRESH_TOKEN).authorizationGrantType(new AuthorizationGrantType(this.grantType()))
                    .build();
            OAuth2Token refreshToken = tokenGenerator.generate(refreshTokenContext);
            Assert.notNull(refreshToken, "RefreshToken should not be null.");

            oAuth2RefreshToken = (OAuth2RefreshToken) refreshToken;
            oAuth2AuthroizationBuilder.refreshToken(oAuth2RefreshToken);
        }

        OAuth2AuthorizationService authorizationService = SpringUtil.getBean(OAuth2AuthorizationService.class);
        Assert.notNull(authorizationService, "OAuth2AuthorizationService should not be null!");
        authorizationService.save(oAuth2AuthroizationBuilder.build());
        SecurityContextHolder.clearContext();

        return new OAuth2AccessTokenAuthenticationToken(registeredClient, clientPrincipal, oAuth2AccessToken, oAuth2RefreshToken);
    }

    /**
     * 构建一个AuthInfo信息
     *
     * @param authUserDO       用户信息
     * @param registeredClient 客户端信息
     * @return AuthInfo
     */
    public AuthInfo buildAuthInfo(AuthUserDO authUserDO, RegisteredClient registeredClient) {
        Long clientId = Long.valueOf(registeredClient.getId());
        AuthInfo.User user = new AuthInfo.User(authUserDO.getId(), authUserDO.getUsername(), authUserDO.getPhone());
        AuthInfo.Client client = new AuthInfo.Client(clientId, registeredClient.getClientId(), registeredClient.getScopes());

        return new AuthInfo(user, client);
    }

    @Override
    public abstract boolean supports(Class<?> authentication);

    public abstract String grantType();

    public abstract Authentication getAuthentication(Authentication authentication, RegisteredClient registeredClient);

}
