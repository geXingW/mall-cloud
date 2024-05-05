package com.gexingw.mall.order.infrastructure.gateway.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.domain.gateway.order.OrderShippingAddressGateway;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.order.infrastructure.convert.order.OrderShippingAddressConvert;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderShippingAddressMapper;
import com.gexingw.mall.order.infrastructure.po.OrderShippingAddressPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/4 19:10
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderShippingAddressGatewayImpl implements OrderShippingAddressGateway {

    private final OrderShippingAddressMapper mapper;

    private final OrderShippingAddressConvert convert;

    @Override
    public OrderShippingAddress getByOrderId(Long orderId) {
        LambdaQueryWrapper<OrderShippingAddressPO> shippingAddressQryWrp = new LambdaQueryWrapper<OrderShippingAddressPO>()
                .eq(OrderShippingAddressPO::getOrderId, orderId);

        return convert.toDomain(mapper.selectOne(shippingAddressQryWrp));
    }

    @Override
    public Long save(OrderShippingAddress shippingAddress) {
        OrderShippingAddressPO shippingAddressPO = convert.toPO(shippingAddress);
        if (mapper.insert(shippingAddressPO) <= 0) {
            return null;
        }

        return shippingAddressPO.getId();
    }

}
