package com.gexingw.mall.auth.infrastructure.component.provider;

import com.gexingw.mall.auth.infrastructure.component.token.OAuth2PasswordAuthenticationToken;
import com.gexingw.mall.auth.infrastructure.constant.ParameterConstant;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserDAO;
import com.gexingw.mall.auth.infrastructure.po.AuthUserPO;
import com.gexingw.mall.auth.infrastructure.po.RegisteredClientPO;
import com.gexingw.mall.common.security.support.AuthInfo;
import com.gexingw.mall.common.spring.util.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;

import java.util.ArrayList;

import static com.gexingw.mall.common.core.enums.AuthRespCode.USERNAME_PASSWD_INVALID;
import static com.gexingw.mall.common.core.enums.CommonRespCode.PARAMS_INVALID;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/16 17:51
 */
public class OAuth2PasswordAuthenticationProvider extends AbstractOAuth2AuthenticationProvider {

    public static final String GRANT_TYPE = "password";

    public final AuthUserDAO authUserDao = SpringUtil.getBean(AuthUserDAO.class);

    @Override
    public boolean supports(Class<?> authentication) {
        return OAuth2PasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public String grantType() {
        return GRANT_TYPE;
    }

    @Override
    public Authentication getAuthentication(Authentication authentication, RegisteredClientPO registeredClient) {
        OAuth2PasswordAuthenticationToken passwordAuthentication = (OAuth2PasswordAuthenticationToken) authentication;

        // 获取用户名
        String username = passwordAuthentication.getAdditionalParams(ParameterConstant.USERNAME).toString();
        // 获取密码
        String password = passwordAuthentication.getAdditionalParams(ParameterConstant.PASSWORD).toString();
        if (StringUtils.isAnyBlank(username, password)) {
            throw new OAuth2AuthenticationException(
                    new OAuth2Error(PARAMS_INVALID.getCode().toString()), PARAMS_INVALID.getMessage()
            );
        }

        // 本次登录的用户
        AuthUserPO authUser = authUserDao.findByUsername(username);
        if (authUser == null || !passwordVerify(password, authUser.getPassword())) {
            // 用户不存在
            throw new OAuth2AuthenticationException(
                    new OAuth2Error(USERNAME_PASSWD_INVALID.getSubCode().toString()), USERNAME_PASSWD_INVALID.getMessage()
            );
        }

        // 认证信息
        AuthInfo authInfo = this.buildAuthInfo(authUser, registeredClient);

        return new UsernamePasswordAuthenticationToken(authInfo, password, new ArrayList<>());
    }

}
