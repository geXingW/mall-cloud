package com.gexingw.mall.order.infrastructure.gateway.order;

import com.gexingw.mall.domain.gateway.order.OrderGateway;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.order.infrastructure.convert.order.OrderConvert;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderMapper;
import com.gexingw.mall.order.infrastructure.po.OrderPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/1/27 16:16
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderGatewayImpl implements OrderGateway {

    private final OrderMapper orderMapper;
    private final OrderConvert orderConvert;

    @Override
    public Long insert(Order order) {
        OrderPO orderPO = orderConvert.toPO(order);
        orderMapper.insert(orderPO);

        return orderPO.getId();
    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public boolean exist(Long id) {
        return false;
    }
}
