package com.gexingw.mall.account.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/31 12:03
 */
@Data
@RefreshScope
@Configuration
@ConfigurationProperties("auth.client")
public class AuthClientConfig {

    /**
     * 商户端
     */
    private ConfigOption merchant = new ConfigOption();

    /**
     * 商城端
     */
    private ConfigOption mall = new ConfigOption();

    /**
     * 平台端
     */
    private ConfigOption platform = new ConfigOption();

    @Data
    public static class ConfigOption {

        /**
         * ClientId
         */
        private String clientId;

        /**
         * ClientSecret
         */
        private String clientSecret;

    }

}
