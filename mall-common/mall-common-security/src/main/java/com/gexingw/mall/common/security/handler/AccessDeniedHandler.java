package com.gexingw.mall.common.security.handler;

import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.web.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 11:09
 */
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
        httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);

        ResponseUtil.jsonResponse(httpResponse, CommonRespCode.FORBIDDEN);
    }

}
