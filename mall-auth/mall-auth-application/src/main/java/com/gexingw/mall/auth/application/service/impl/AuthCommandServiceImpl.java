package com.gexingw.mall.auth.application.service.impl;

import com.gexingw.mall.auth.application.service.AuthCommandService;
import com.gexingw.mall.auth.infrastructure.support.AuthRespCode;
import com.gexingw.mall.auth.infrastructure.support.MallAuthBizException;
import com.gexingw.mall.common.core.constant.OAuth2Constant;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/27 13:01
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class AuthCommandServiceImpl implements AuthCommandService {

    private final OAuth2AuthorizationService oAuth2AuthorizationService;

    @Resource(name = "javaSerializerRedisTemplate")
    private RedisTemplate<String, Object> javaSerializerRedisTemplate;

    @Override
    public void logout(@Nullable String accessToken) {
        if (StringUtils.isBlank(accessToken)) {
            throw new MallAuthBizException(AuthRespCode.UN_AUTHORIZED);
        }

        String redisAccessTokenKey = String.format(OAuth2Constant.ACCESS_TOKEN_CACHE_NAME, accessToken);
        OAuth2Authorization authorization = (OAuth2Authorization) javaSerializerRedisTemplate.opsForValue().get(redisAccessTokenKey);
        if (authorization == null) {
            throw new MallAuthBizException(AuthRespCode.UN_AUTHORIZED);
        }

        oAuth2AuthorizationService.remove(authorization);
    }

}
