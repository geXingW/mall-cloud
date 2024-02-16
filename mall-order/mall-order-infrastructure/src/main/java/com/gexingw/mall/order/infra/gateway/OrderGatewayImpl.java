package com.gexingw.mall.order.infra.gateway;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.domain.gateway.OrderGateway;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.order.infra.convert.order.OrderConvert;
import com.gexingw.mall.order.infra.dataobject.OrderDO;
import com.gexingw.mall.order.infra.gateway.db.OrderMapper;
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
    public Order getById(Long id) {
        OrderDO orderDO = orderMapper.selectById(id);
        if (orderDO == null) {
            return null;
        }

        return orderConvert.toDomain(orderDO);
    }

    @Override
    public boolean exist(Long id) {
        return orderMapper.exists(new LambdaQueryWrapper<OrderDO>().eq(OrderDO::getId, id));
    }

}
