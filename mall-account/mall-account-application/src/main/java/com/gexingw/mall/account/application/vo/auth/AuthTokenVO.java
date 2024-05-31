package com.gexingw.mall.account.application.vo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthTokenVO implements Serializable {

    /**
     * Access_token
     */
    private String accessToken;

    private String refreshToken;

    private String scope;

    private String tokenType;

    private Integer expiresIn;

}
