package com.gexingw.mall.order.infra.gateway;

import com.gexingw.mall.domain.gateway.ShippingAddressGateway;
import com.gexingw.mall.domain.order.model.OrderShippingAddress;
import com.gexingw.mall.order.infra.convert.order.OrderShippingAddressConvert;
import com.gexingw.mall.order.infra.gateway.rpc.ShippingAddressMapper;
import com.gexingw.mall.user.client.clientobject.address.ShippingAddressCO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/12 19:29
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ShippingAddressGatewayImpl implements ShippingAddressGateway {

    private final ShippingAddressMapper shippingAddressMapper;
    private final OrderShippingAddressConvert orderShippingAddressConvert;

    @Override
    public OrderShippingAddress getById(Long id) {
        ShippingAddressCO shippingAddressCo = shippingAddressMapper.getById(id);

        return orderShippingAddressConvert.toDomain(shippingAddressCo);
    }

}
