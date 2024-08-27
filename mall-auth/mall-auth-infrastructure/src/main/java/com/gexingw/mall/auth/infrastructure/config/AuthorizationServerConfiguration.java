package com.gexingw.mall.auth.infrastructure.config;

import com.gexingw.mall.auth.infrastructure.component.RedisOAuth2AuthorizationService;
import com.gexingw.mall.auth.infrastructure.component.convert.OAuth2PasswordAuthenticationConvert;
import com.gexingw.mall.auth.infrastructure.component.filter.ServletRequestJsonParamsWrapperFilter;
import com.gexingw.mall.auth.infrastructure.component.provider.OAuth2PasswordAuthenticationProvider;
import com.gexingw.mall.auth.infrastructure.handler.AuthenticationFailureHandler;
import com.gexingw.mall.common.security.handler.AccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.token.DelegatingOAuth2TokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2AccessTokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2RefreshTokenGenerator;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.sql.DataSource;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 9:01
 */
@Configuration
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthorizationServerConfiguration {

    private final PasswordEncoder passwordEncoder;
    private final ServletRequestJsonParamsWrapperFilter servletRequestJsonParamsWrapperFilter;

    @Bean
    @SneakyThrows
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationFilterChain(HttpSecurity httpSecurity) {
        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();
        authorizationServerConfigurer
                .tokenEndpoint(tokenEndpoint -> tokenEndpoint
                        .errorResponseHandler(new AuthenticationFailureHandler())
                        // 密码模式
                        .accessTokenRequestConverter(new OAuth2PasswordAuthenticationConvert())
                        .authenticationProvider(new OAuth2PasswordAuthenticationProvider())
                )
                .authorizationEndpoint(authorizationEndpoint -> authorizationEndpoint.errorResponseHandler(new AuthenticationFailureHandler()))
                .clientAuthentication(
                        clientAuthentication -> clientAuthentication.errorResponseHandler(new AuthenticationFailureHandler())
                );

        RequestMatcher endpointsMatcher = authorizationServerConfigurer.getEndpointsMatcher();
        httpSecurity.requestMatcher(endpointsMatcher)
                .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .csrf(csrf -> csrf.ignoringRequestMatchers(endpointsMatcher));

        httpSecurity.exceptionHandling(exception -> exception.accessDeniedHandler(new AccessDeniedHandler()));
        httpSecurity.apply(authorizationServerConfigurer);
        httpSecurity.addFilterBefore(servletRequestJsonParamsWrapperFilter, ChannelProcessingFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public OAuth2TokenGenerator<OAuth2Token> oAuth2TokenGenerator() {
        return new DelegatingOAuth2TokenGenerator(new OAuth2AccessTokenGenerator(), new OAuth2RefreshTokenGenerator());
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }

//    @Bean
//    public OAuth2AuthorizationService oAuth2AuthorizationService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
//        return new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
//    }

    @Bean
    public OAuth2AuthorizationService oAuth2AuthorizationService(RedisTemplate<Object, Object> restTemplate, RedisSerializer<Object> redisSerializer) {
        return new RedisOAuth2AuthorizationService(restTemplate, redisSerializer);
    }

}
