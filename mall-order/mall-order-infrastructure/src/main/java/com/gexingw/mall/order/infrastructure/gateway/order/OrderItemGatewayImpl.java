package com.gexingw.mall.order.infrastructure.gateway.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.domain.gateway.order.OrderItemGateway;
import com.gexingw.mall.domain.model.order.OrderItem;
import com.gexingw.mall.order.infrastructure.convert.order.OrderItemConvert;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderItemMapper;
import com.gexingw.mall.order.infrastructure.po.OrderItemPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        if (orderItemMapper.insert(orderItemPO) <= 0) {
            return 0L;
        }

        return orderItemPO.getId();
    }

    @Override
    public List<OrderItem> queryByOrderId(Long id) {
        // 查找订单商品信息
        LambdaQueryWrapper<OrderItemPO> itemQryWrp = new LambdaQueryWrapper<OrderItemPO>().eq(OrderItemPO::getOrderId, id);

        return orderItemMapper.selectList(itemQryWrp).stream().map(orderItemConvert::toDomain).collect(Collectors.toList());
    }

}
