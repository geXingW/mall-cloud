package com.gexingw.mall.auth.client.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/7/5 10:36
 */
@Data
@NoArgsConstructor
public class PasswordLoginCommand implements Serializable {

    @JsonProperty("grant_type")
    private final String grantType = "password";

    @JsonProperty("client_id")
    private String clientId = "";

    @JsonProperty("client_secret")
    private String clientSecret = "";

    @JsonProperty("username")
    private String username = "";

    @JsonProperty("password")
    private String password = "";

    public PasswordLoginCommand(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public PasswordLoginCommand(String clientId, String clientSecret, String username, String password) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    public PasswordLoginCommand withClient(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        return this;
    }

    public PasswordLoginCommand withCredential(String username, String password) {
        this.username = username;
        this.password = password;

        return this;
    }

}
