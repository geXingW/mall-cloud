package com.gexingw.mall.user.domain.auth;

import lombok.Getter;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/13 15:33
 */
@Getter
public class AuthToken implements Serializable {

    private final String accessToken;

    private final String refreshToken;

    private final String tokenType;

    private final String scope;

    private final Long expiresIn;

    public AuthToken(String accessToken, String tokenType, String scope, Long expiresIn) {
        this(accessToken, null, tokenType, scope, expiresIn);
    }

    public AuthToken(String accessToken, String refreshToken, String tokenType, String scope, Long expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.scope = scope;
        this.expiresIn = expiresIn;
    }

}
