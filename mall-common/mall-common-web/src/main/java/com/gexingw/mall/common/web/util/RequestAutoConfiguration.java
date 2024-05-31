package com.gexingw.mall.common.web.util;

import com.alibaba.fastjson2.support.spring.http.converter.FastJsonHttpMessageConverter;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 17:45
 */
@Configuration
public class RequestAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ConnectionPool httpClientConnectionPool() {
        return new ConnectionPool(5, 5, TimeUnit.MINUTES);
    }

    @Bean
    @ConditionalOnMissingBean
    okhttp3.OkHttpClient okHttpClient(ConnectionPool connectionPool) {
        return new okhttp3.OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .connectTimeout(Duration.ofSeconds(60))
                .readTimeout(Duration.ofMinutes(1))
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, OkHttpClient okHttpClient) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(() -> new OkHttp3ClientHttpRequestFactory(okHttpClient)).build();
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        messageConverters.add(new FastJsonHttpMessageConverter());

        return restTemplate;
    }

}
