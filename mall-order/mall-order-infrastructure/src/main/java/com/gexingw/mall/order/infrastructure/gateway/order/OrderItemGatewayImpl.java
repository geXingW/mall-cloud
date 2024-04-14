package com.gexingw.mall.order.infrastructure.gateway.order;

import com.gexingw.mall.domain.gateway.OrderItemGateway;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.order.infrastructure.convert.order.OrderItemConvert;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderItemMapper;
import com.gexingw.mall.order.infrastructure.po.OrderItemPO;
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

    private final OrderItemConvert orderItemConvert;

    @Override
    public Long insert(OrderItem orderItem) {
        OrderItemPO orderItemPO = orderItemConvert.toPO(orderItem);
        orderItemMapper.insert(orderItemPO);

        return orderItemPO.getId();
    }

}
