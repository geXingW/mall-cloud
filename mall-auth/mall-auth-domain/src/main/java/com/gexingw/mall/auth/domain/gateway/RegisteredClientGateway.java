package com.gexingw.mall.auth.domain.gateway;

import com.gexingw.mall.auth.domain.model.RegisteredClient;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 23:11
 */
public interface RegisteredClientGateway {

    Boolean insert(RegisteredClient registeredClient);

}
