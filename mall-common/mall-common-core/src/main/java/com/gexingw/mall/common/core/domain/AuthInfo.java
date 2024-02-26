package com.gexingw.mall.common.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
public class AuthInfo implements AggregationRoot {

    private Long id;

    private User authUser;
    private Client client;

    /**
     * 认证用户信息
     */
    @Data
    @Accessors(chain = true)
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

}
