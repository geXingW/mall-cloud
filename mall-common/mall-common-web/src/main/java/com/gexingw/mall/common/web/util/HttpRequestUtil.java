package com.gexingw.mall.common.web.util;

import com.alibaba.fastjson2.JSON;
import com.gexingw.mall.common.spring.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 14:39
 */
@Slf4j
@SuppressWarnings("unused")
public class HttpRequestUtil {

    private static volatile RestTemplate restTemplate;

    public static <T> T get(String url, Class<T> responseType) {
        return execute(url, HttpMethod.GET, null, null, responseType);
    }

    public static <T> T get(String url, Map<String, Object> params, Class<T> responseType) {
        return execute(url, HttpMethod.GET, null, params, responseType);
    }

    public static <T> T post(String url, Map<String, Object> queryParams, Class<T> responseType) {
        return execute(url, HttpMethod.POST, null, queryParams, responseType);
    }

    public static <T> T post(String url, HttpEntity<T> httpEntity, Class<T> responseType) {
        return execute(url, HttpMethod.POST, httpEntity, null, responseType);
    }

    public static <T> T postJson(String url, Object bodyParams, Class<T> responseType) {
        return execute(url, HttpMethod.POST, buildJsonHttpEntity(bodyParams), null, responseType);
    }

    public static <T> T put(String url, Class<T> responseType) {
        return execute(url, HttpMethod.PUT, null, null, responseType);
    }

    public static <T> T put(String url, Map<String, Object> queryParams, Class<T> responseType) {
        return execute(url, HttpMethod.PUT, null, queryParams, responseType);
    }

    public static <T> T putJson(String url, Class<T> responseType, Map<String, Object> bodyParams) {
        return execute(url, HttpMethod.PUT, buildJsonHttpEntity(bodyParams), null, responseType);
    }

    public static <T> T execute(
            @NotNull String url, @NotNull HttpMethod httpMethod, @Nullable HttpEntity<?> httpEntity,
            @Nullable Map<String, Object> queryParams, @NotNull Class<T> responseType
    ) {
        RestTemplate restTemplate = getRestTemplate();

        // 如果queryParams为null，则创建一个空的Map
        queryParams = queryParams == null ? new HashMap<>(0) : queryParams;
        if (!queryParams.isEmpty()) {
            // 拼接参数
            //noinspection VulnerableCodeUsages
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
            //noinspection VulnerableCodeUsages
            queryParams.forEach(uriComponentsBuilder::queryParam);
            //noinspection VulnerableCodeUsages
            url = uriComponentsBuilder.toUriString();
        }

        RequestCallback requestCallback = null;
        if (httpEntity != null) {
            requestCallback = restTemplate.httpEntityCallback(httpEntity, responseType);
        }

        String queryParamsJsonStr = JSON.toJSONString(queryParams);
        String bodyJsonStr = JSON.toJSONString(httpEntity.getBody());

        log.info("Query 参数：{}", queryParamsJsonStr);
        log.info("Body 参数：{}", bodyJsonStr);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor<>(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, queryParams);
    }

    /**
     * 获取RestTemplate实例
     *
     * @return RestTemplate
     */
    private static RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            synchronized (HttpRequestUtil.class) {
                if (restTemplate == null) {
                    restTemplate = SpringUtil.getBean(RestTemplate.class);
                }
            }
        }

        return restTemplate;
    }

    private static HttpEntity<Object> buildJsonHttpEntity(Object bodyParams) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(bodyParams, httpHeaders);
    }

}
