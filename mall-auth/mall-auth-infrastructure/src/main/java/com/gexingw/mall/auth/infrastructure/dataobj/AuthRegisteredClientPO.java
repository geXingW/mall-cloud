package com.gexingw.mall.auth.infrastructure.dataobj;

import com.gexingw.mall.common.db.support.BasePO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 13:03
 */
@Data
public class AuthRegisteredClientPO extends BasePO {

    private String clientName;

    private String clientId;

    private LocalDateTime clientIdIssuedAt;

    private String clientSecret;

    private LocalDateTime clientSecretExpiresAt;

    private String clientAuthenticationMethods;

    private String authorizationGrantTypes;

    private String redirectUris;

    private String scopes;

    private String clientSettings;

    private String tokenSettings;

}
