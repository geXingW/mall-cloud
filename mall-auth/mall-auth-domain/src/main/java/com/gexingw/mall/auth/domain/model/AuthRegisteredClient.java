package com.gexingw.mall.auth.domain.model;

import com.gexingw.mall.common.core.domain.Entity;
import lombok.Data;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 13:15
 */
@Data
public class AuthRegisteredClient implements Entity {

    private Long id;

    private String clientId;

    private String clientSecret;

    private String clientName;

}
