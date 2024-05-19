package com.gexingw.mall.auth.infrastructure.gateway.regsteredclient;

import com.gexingw.mall.auth.domain.gateway.RegisteredClientGateway;
import com.gexingw.mall.auth.domain.model.RegisteredClient;
import com.gexingw.mall.auth.infrastructure.convert.RegisteredClientConvert;
import com.gexingw.mall.auth.infrastructure.gateway.regsteredclient.db.RegisteredClientDAO;
import com.gexingw.mall.auth.infrastructure.po.RegisteredClientPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/18 23:10
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class RegisteredClientGatewayImpl implements RegisteredClientGateway {

    private final RegisteredClientDAO registeredClientDAO;

    private final RegisteredClientConvert registeredClientConvert;

    @Override
    public Boolean insert(RegisteredClient registeredClient) {
        RegisteredClientPO clientConvertPO = registeredClientConvert.toPO(registeredClient);
        registeredClientDAO.save(clientConvertPO);

        registeredClient.setId(clientConvertPO.getId());

        return true;
    }

}
