package com.gexingw.mall.common.security.introspector;

import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 18:50
 */
public class RedisOpaqueTokenIntrospector implements OpaqueTokenIntrospector {


    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {

        return null;
    }

}
