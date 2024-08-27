package com.gexingw.mall.common.security.support;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 18:24
 */
@NoArgsConstructor
@JsonTypeInfo(use = Id.CLASS, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Authentication.class, name = "Authentication")
})
public class Authentication implements org.springframework.security.core.Authentication {

    private boolean authenticated;

    @Getter
    private AuthInfo authInfo;

    public Authentication(@NotNull AuthInfo authInfo) {
        this.authInfo = authInfo;
        this.authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return this.getAuthInfo().getAuthUserName();
    }

}
