package com.gexingw.mall.auth.infrastructure.component.provider;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.auth.infrastructure.component.token.OAuth2PasswordAuthenticationToken;
import com.gexingw.mall.auth.infrastructure.constant.ParameterConstant;
import com.gexingw.mall.auth.infrastructure.dataobj.AuthUserPO;
import com.gexingw.mall.auth.infrastructure.gateway.authuser.db.AuthUserMapper;
import com.gexingw.mall.common.core.domain.AuthInfo;
import com.gexingw.mall.common.spring.util.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

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

    @Override
    public boolean supports(Class<?> authentication) {
        return OAuth2PasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public String grantType() {
        return GRANT_TYPE;
    }

    @Override
    public Authentication getAuthentication(Authentication authentication, RegisteredClient registeredClient) {
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

        // 根据用户名查找用户信息
        LambdaQueryWrapper<AuthUserPO> qryWrapper = new LambdaQueryWrapper<AuthUserPO>().eq(AuthUserPO::getUsername, username);
        AuthUserMapper bean = SpringUtil.getBean(AuthUserMapper.class);
        AuthUserPO authUserPO = bean.selectOne(qryWrapper);
        if (authUserPO == null) {
            throw new OAuth2AuthenticationException(
                    new OAuth2Error(USERNAME_PASSWD_INVALID.getSubCode().toString()), USERNAME_PASSWD_INVALID.getMessage()
            );
        }

        // 校验密码
        if (!password.equals(authUserPO.getPassword())) {
            throw new OAuth2AuthenticationException(
                    new OAuth2Error(USERNAME_PASSWD_INVALID.getSubCode().toString()), USERNAME_PASSWD_INVALID.getMessage()
            );
        }

        // 认证信息
        AuthInfo authInfo = this.buildAuthInfo(authUserPO, registeredClient);

        return new UsernamePasswordAuthenticationToken(authInfo, password, new ArrayList<>());
    }

}
