package com.gexingw.mall.order.infrastructure.gateway.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.domain.gateway.order.OrderGateway;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.order.infrastructure.convert.order.OrderConvert;
import com.gexingw.mall.order.infrastructure.convert.order.OrderItemConvert;
import com.gexingw.mall.order.infrastructure.convert.order.OrderShippingAddressConvert;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderItemMapper;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderMapper;
import com.gexingw.mall.order.infrastructure.gateway.order.db.OrderShippingAddressMapper;
import com.gexingw.mall.order.infrastructure.po.OrderItemPO;
import com.gexingw.mall.order.infrastructure.po.OrderPO;
import com.gexingw.mall.order.infrastructure.po.OrderShippingAddressPO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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
    private final OrderItemMapper itemMapper;
    private final OrderShippingAddressMapper shippingAddressMapper;

    private final OrderConvert orderConvert;
    private final OrderItemConvert itemConvert;
    private final OrderShippingAddressConvert shippingAddressConvert;

    @Override
    public Long insert(Order order) {
        OrderPO orderPO = orderConvert.toPO(order);
        orderMapper.insert(orderPO);

        return orderPO.getId();
    }

    @Override
    public Order selectById(Long id) {
        // 查询订单主信息
        OrderPO orderPO = orderMapper.selectById(id);
        if (orderPO == null) {
            return null;
        }
        Order order = orderConvert.toDomain(orderPO);

        // 查找订单商品信息
        LambdaQueryWrapper<OrderItemPO> itemQryWrp = new LambdaQueryWrapper<OrderItemPO>().eq(OrderItemPO::getOrderId, id);
        order.setItems(itemMapper.selectList(itemQryWrp).stream().map(itemConvert::toDomain).collect(Collectors.toList()));

        // 收货地址
        LambdaQueryWrapper<OrderShippingAddressPO> shippingAddressQryWrp = new LambdaQueryWrapper<OrderShippingAddressPO>()
                .eq(OrderShippingAddressPO::getOrderId, id);
        order.setShippingAddress(shippingAddressConvert.toDomain(shippingAddressMapper.selectOne(shippingAddressQryWrp)));

        return order;
    }

    @Override
    public boolean exist(Long id) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        OrderPO orderPO = orderConvert.toPO(order);
        return orderMapper.updateById(orderPO) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return orderMapper.deleteById(id) > 0;
    }

}
