package com.gexingw.mall.common.security.config;

import com.gexingw.mall.common.security.constant.PasswordConstant;
import com.gexingw.mall.common.security.filter.AuthenticationFilter;
import com.gexingw.mall.common.security.handler.AccessDeniedHandler;
import com.gexingw.mall.common.security.handler.AuthenticationEntryPointHandler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;
import java.util.Map;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 9:05
 */
@AutoConfiguration
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class SecurityAutoConfiguration {

    private final AuthenticationFilter authenticationFilter;
    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    @Order(2)
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        // 禁用CSRF
        httpSecurity.csrf().disable();

        // 禁用跨域
        httpSecurity.cors().disable();

        // 无状态Session
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.logout(AbstractHttpConfigurer::disable);

        // 认证过滤器
        httpSecurity.addFilterAt(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // 认证异常配置
        httpSecurity.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint);


        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = Collections.singletonMap(PasswordConstant.BCRYPT_ENCODER_ID, new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(PasswordConstant.BCRYPT_ENCODER_ID, encoders);
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointHandler();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }

}
