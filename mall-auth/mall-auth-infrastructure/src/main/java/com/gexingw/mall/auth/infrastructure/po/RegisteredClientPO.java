package com.gexingw.mall.auth.infrastructure.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 13:03
 */
@Entity
@Data
@Table(name = "oauth2_registered_client")
public class RegisteredClientPO {

    @Id
    @GeneratedValue
    private Long id;

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

    /**
     * 客户端类型
     */
    private Integer clientType;

}
