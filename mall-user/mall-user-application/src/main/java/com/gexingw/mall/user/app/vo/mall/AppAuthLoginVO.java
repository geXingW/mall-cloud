package com.gexingw.mall.user.app.vo.mall;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/4 18:16
 */
@Data
public class AppAuthLoginVO implements Serializable {

    private String accessToken;

    private String tokenType;

    private String scope;

    private Long expiresIn;

}
