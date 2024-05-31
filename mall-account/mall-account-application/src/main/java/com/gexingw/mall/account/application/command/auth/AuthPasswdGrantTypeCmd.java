package com.gexingw.mall.account.application.command.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gexingw.mall.account.infrastructure.config.AuthClientConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/21 16:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AuthPasswdGrantTypeCmd implements Serializable {

    @JsonProperty("grant_type")
    private String grantType = "password";

    @JsonProperty("client_id")
    private String clientId = "";

    @JsonProperty("client_id")
    private String clientSecret = "";

    private String username = "";

    private String password = "";

    public AuthPasswdGrantTypeCmd(String clientId, String clientSecret, String username, String password) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    public AuthPasswdGrantTypeCmd(AuthClientConfig.ConfigOption clientConfigOption) {
        this.clientId = clientConfigOption.getClientId();
        this.clientSecret = clientConfigOption.getClientSecret();
    }

}
