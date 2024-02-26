package com.gexingw.mall.gateway.filter;

import cn.hutool.core.text.AntPathMatcher;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 22:20
 */
@Data
@RefreshScope
@Configuration
@ConfigurationProperties("mall.security")
public class AuthenticationConfiguration {

    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    private final List<String> skipTokenUrl = new ArrayList<>();

    public boolean shouldSkipToken(String path) {
        return true;
//
//        for (String url : skipTokenUrl) {
//            if (ANT_PATH_MATCHER.match(url, path)) {
//                return true;
//            }
//        }
//
//        return false;
    }

}
