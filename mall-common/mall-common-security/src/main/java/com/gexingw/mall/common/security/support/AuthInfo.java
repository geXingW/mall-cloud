package com.gexingw.mall.common.security.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gexingw.mall.common.core.domain.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 22:38
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AuthInfo.class, name = "AuthInfo"),
        @JsonSubTypes.Type(value = AuthInfo.User.class, name = "authUser"),
        @JsonSubTypes.Type(value = AuthInfo.Client.class, name = "client")
})
public class AuthInfo implements Serializable {

    private Long id;

    private User authUser;

    private Client client;

    /**
     * 认证用户信息
     */
    @Data
    @Accessors(chain = true)
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    public static class User implements Entity {

        private Long id;

        private String username;

        private String phone;

        public User(Long id, String username, String phone) {
            this.id = id;
            this.username = username;
            this.phone = phone;
        }
    }

    /**
     * 认证的客户端
     */
    @Data
    @Accessors(chain = true)
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
    public static class Client implements Entity {

        private Long id;

        private String clientId;

        private Set<String> scopes;

        public Client(Long id, String clientId, Set<String> scopes) {
            this.id = id;
            this.clientId = clientId;
            this.scopes = scopes;
        }

    }

    public AuthInfo(User authUser, Client client) {
        this.id = authUser.getId();
        this.authUser = authUser;
        this.client = client;
    }

    @JsonIgnore
    public String getAuthUserName() {
        return this.authUser.getUsername();
    }

}
