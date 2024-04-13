package com.gexingw.mall.order.infra.gateway;

import com.gexingw.mall.order.infra.gateway.db.OrderItemMapper;
import com.gexingw.mall.order.infra.po.OrderItemPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author GeXingW
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderItemGatewayImpl implements OrderItemGateway {

    private final OrderItemMapper orderItemMapper;

    @Override
    public void insert(OrderItemPO orderItemPO) {
        orderItemMapper.insert(orderItemPO);
    }

}
