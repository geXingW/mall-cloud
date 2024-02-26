package com.gexingw.mall.auth.infrastructure.component.convert;

import com.gexingw.mall.auth.infrastructure.component.provider.OAuth2PasswordAuthenticationProvider;
import com.gexingw.mall.auth.infrastructure.constant.ParameterConstant;
import com.gexingw.mall.auth.infrastructure.component.token.OAuth2PasswordAuthenticationToken;
import com.gexingw.mall.common.web.util.HttpParamUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 22:26
 */
public class OAuth2PasswordAuthenticationConvert extends AbstractAuthenticationConvert{

    @Override
    public Authentication convert(javax.servlet.http.HttpServletRequest request) {
        String grantType = request.getParameter(ParameterConstant.GRANT_TYPE);
        if(!OAuth2PasswordAuthenticationProvider.GRANT_TYPE.equals(grantType)) {
            return null;
        }

        Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> additionalParams = HttpParamUtil.getRequestParams(request);

        return new OAuth2PasswordAuthenticationToken(clientPrincipal, additionalParams);
    }

}
