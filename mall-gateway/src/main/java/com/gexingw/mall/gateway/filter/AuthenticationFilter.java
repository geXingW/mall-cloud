package com.gexingw.mall.gateway.filter;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson2.JSON;
import com.alibaba.nacos.common.utils.JacksonUtils;
import com.gexingw.mall.common.core.constant.AuthConstant;
import com.gexingw.mall.common.core.constant.OAuth2Constant;
import com.gexingw.mall.common.core.enums.AuthRespCode;
import com.gexingw.mall.common.core.interfaces.IRespCode;
import com.gexingw.mall.common.core.util.R;
import com.gexingw.mall.common.redis.config.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 22:15
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthenticationFilter implements GlobalFilter, Ordered {

    private final AuthenticationConfiguration authenticationConfiguration;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();

        // 是否跳过Token检查
        if (authenticationConfiguration.shouldSkipToken(path)) {
            return chain.filter(exchange);
        }

        // 检查Token
        String accessToken = StringUtils.removeStart(request.getHeaders().getFirst("Authorization"), "Bearer ");
        if (StringUtils.isBlank(accessToken)) {
            return this.handlerResponse(AuthRespCode.TOKEN_EXPIRED, exchange.getResponse());
        }

        Object authInfo = RedisUtil.get(String.format(OAuth2Constant.ACCESS_TOKEN_AUTH_INFO_CACHE_NAME, accessToken));
        if (authInfo == null) {
            return this.handlerResponse(AuthRespCode.TOKEN_EXPIRED, exchange.getResponse());
        }

        // 通过Header进行用户信息的透传
        request.mutate().header(AuthConstant.HEADER_AUTH_INFO, Base64.encode(JacksonUtils.toJson(authInfo)));

        return chain.filter(exchange);
    }

    @SuppressWarnings("SameParameterValue")
    private Mono<Void> handlerResponse(IRespCode respCode, ServerHttpResponse response) {
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        DataBuffer buffer = response.bufferFactory().wrap(JSON.toJSONString(R.fail(respCode)).getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Flux.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
