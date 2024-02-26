package com.gexingw.mall.auth.infrastructure.handler;

import com.gexingw.mall.common.core.enums.AuthRespCode;
import com.gexingw.mall.common.core.enums.CommonRespCode;
import com.gexingw.mall.common.web.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 11:23
 */
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        try (ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response)) {
            httpResponse.setStatusCode(HttpStatus.OK);
            OAuth2Error error = ((OAuth2AuthenticationException) exception).getError();
            if (Arrays.asList("invalid_client", "unauthorized_client", "invalid_grant").contains(error.getErrorCode())) {
                ResponseUtil.jsonResponse(httpResponse, AuthRespCode.INVALID_CLIENT);
                return;
            }

            Integer subCode = Integer.valueOf(error.getErrorCode());
            ResponseUtil.jsonResponse(httpResponse, CommonRespCode.UNAUTHORIZED.getCode(), subCode, error.getDescription());
        }
    }

}
