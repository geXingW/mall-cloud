package com.gexingw.mall.auth.infrastructure.gateway.regsteredclient;

import com.gexingw.mall.auth.domain.gateway.RegisteredClientGateway;
import com.gexingw.mall.auth.domain.model.RegisteredClient;
import com.gexingw.mall.auth.infrastructure.convert.RegisteredClientConvert;
import com.gexingw.mall.auth.infrastructure.gateway.regsteredclient.db.RegisteredClientMapper;
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

    private final RegisteredClientMapper registeredClientMapper;

    private final RegisteredClientConvert registeredClientConvert;

    @Override
    public Boolean insert(RegisteredClient registeredClient) {
        RegisteredClientPO clientConvertPO = registeredClientConvert.toPO(registeredClient);
        if (registeredClientMapper.insert(clientConvertPO) == 0) {
            return false;
        }
        registeredClient.setId(clientConvertPO.getId());

        return true;
    }

}
