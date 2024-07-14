package com.gexingw.mall.auth.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/31 13:57
 */
@Data
public class RegisteredClientCreateResultVO implements Serializable {

    private String clientId;

    private String clientSecret;

}
