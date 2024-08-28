package com.gexingw.mall.common.security.filter;

import cn.hutool.core.codec.Base64Decoder;
import com.alibaba.fastjson2.JSON;
import com.gexingw.mall.common.core.constant.AuthConstant;
import com.gexingw.mall.common.security.support.AuthInfo;
import com.gexingw.mall.common.security.support.Authentication;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 12:50
 */
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    @SneakyThrows
    protected void doFilterInternal(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable FilterChain filterChain) {
        log.info("AuthenticationFilter class....");
        if (filterChain == null || request == null) {
            return;
        }

        // 拿到请求头中的用户信息
        String headerAuthStr = request.getHeader(AuthConstant.HEADER_AUTH_INFO);
        if (StringUtils.isBlank(headerAuthStr)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Base64解码
        AuthInfo authInfo = JSON.parseObject(Base64Decoder.decodeStr(headerAuthStr), AuthInfo.class);
        // 写入到 SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(new Authentication(authInfo));
        filterChain.doFilter(request, response);

        // 清除认证信息
        SecurityContextHolder.clearContext();
    }

}
