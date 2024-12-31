package top.gexingw.mall.service.user.client.co.mall.user;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/11/19 15:42
 */
@Data
public class MallUserAuthTokenCO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Access Token
     */
    private final String accessToken;

    /**
     * Refresh Token
     */
    private final String refreshToken;

    /**
     * Token Type
     */
    private final String tokenType;

    /**
     * Scope
     */
    private final String scope;

    /**
     * Expires In
     */
    private final Long expiresIn;

}
