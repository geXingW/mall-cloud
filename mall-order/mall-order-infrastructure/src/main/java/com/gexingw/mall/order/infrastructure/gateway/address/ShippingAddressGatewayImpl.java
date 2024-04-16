package com.gexingw.mall.order.infrastructure.gateway.address;

import com.gexingw.mall.domain.gateway.address.ShippingAddressGateway;
import com.gexingw.mall.domain.model.address.ShippingAddress;
import com.gexingw.mall.order.infrastructure.convert.address.ShippingAddressConvert;
import com.gexingw.mall.order.infrastructure.gateway.address.db.ShippingAddressMapper;
import com.gexingw.mall.order.infrastructure.po.ShippingAddressPO;
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

    private final ShippingAddressConvert shippingAddressConvert;

    @Override
    public ShippingAddress find(Long id) {
        ShippingAddressPO shippingAddressPO = shippingAddressMapper.selectById(id);

        return shippingAddressConvert.toDomain(shippingAddressPO);
    }

    @Override
    public Long save(ShippingAddress shippingAddress) {
        ShippingAddressPO shippingAddressPO = shippingAddressConvert.toPO(shippingAddress);
        shippingAddressMapper.insert(shippingAddressPO);

        return shippingAddressPO.getId();
    }

}
