package com.gexingw.mall.order.infra.gateway;

import com.gexingw.mall.domain.user.UserGateway;
import com.gexingw.mall.domain.user.model.User;
import com.gexingw.mall.order.infra.convert.user.UserConvert;
import com.gexingw.mall.order.infra.gateway.rpc.UserRpcMapper;
import com.gexingw.mall.user.client.clientobject.user.UserCO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/15 12:53
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserGatewayImpl implements UserGateway {

    private final UserRpcMapper userRpcMapper;
    private final UserConvert userConvert;

    @Override
    public User getById(long id) {
        UserCO userCo = userRpcMapper.getById(id);
        if(userCo == null) {
            return null;
        }

        return userConvert.toDomain(userCo);
    }

}
