package com.gexingw.mall.user.app.vo.web.mall.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 14:13
 */
@Data
public class WebMallAuthTokenVO implements Serializable {

    private String accessToken;

    private String tokenType;

    private String scope;

    private Long expiresIn;

}
