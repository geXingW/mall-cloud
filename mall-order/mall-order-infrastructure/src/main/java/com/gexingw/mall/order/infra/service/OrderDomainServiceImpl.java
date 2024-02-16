package com.gexingw.mall.order.infra.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gexingw.mall.domain.order.model.Order;
import com.gexingw.mall.domain.order.model.OrderItem;
import com.gexingw.mall.domain.service.OrderDomainService;
import com.gexingw.mall.order.infra.convert.order.OrderConvert;
import com.gexingw.mall.order.infra.convert.order.OrderItemDOConvert;
import com.gexingw.mall.order.infra.convert.order.OrderShippingAddressConvert;
import com.gexingw.mall.order.infra.dataobject.OrderDO;
import com.gexingw.mall.order.infra.dataobject.OrderItemDO;
import com.gexingw.mall.order.infra.dataobject.OrderShippingAddressDO;
import com.gexingw.mall.order.infra.gateway.db.OrderItemMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderMapper;
import com.gexingw.mall.order.infra.gateway.db.OrderShippingAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 16:17
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderDomainServiceImpl implements OrderDomainService {

    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final OrderShippingAddressMapper orderShippingAddressMapper;

    private final OrderConvert orderConvert;
    private final OrderItemDOConvert orderItemConvert;
    private final OrderShippingAddressConvert orderShippingAddressConvert;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long save(Order order) {
        // 保存订单主信息
        OrderDO orderDO = orderConvert.toDO(order);
        orderMapper.insert(orderDO);

        // 保存订单商品信息
        for (OrderItem orderItem : order.getOrderItems()) {
            OrderItemDO orderItemDO = orderItemConvert.toDO(orderItem);
            orderItemDO.setOrderId(orderDO.getId());
            orderItemMapper.insert(orderItemDO);
        }

        // 保存订单收货地址
        OrderShippingAddressDO shippingAddressDO = orderShippingAddressConvert.toDO(order.getOrderShippingAddress());
        shippingAddressDO.setOrderId(orderDO.getId());
        orderShippingAddressMapper.insert(shippingAddressDO);

        return orderDO.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long id) {
        // 删除订单主信息
        if (orderMapper.deleteById(id) == 0) {
            return false;
        }

        // 删除订单商品信息
        if (orderItemMapper.delete(new LambdaQueryWrapper<OrderItemDO>().eq(OrderItemDO::getOrderId, id)) == 0) {
            return false;
        }

        // 删除订单收货地址信息
        LambdaQueryWrapper<OrderShippingAddressDO> deleteQryWrapper = new LambdaQueryWrapper<OrderShippingAddressDO>()
                .eq(OrderShippingAddressDO::getOrderId, id);
        return orderShippingAddressMapper.delete(deleteQryWrapper) != 0;
    }

    @Override
    public Order getById(Long id) {
        // 查询订单主信息
        OrderDO orderDO = orderMapper.selectById(id);
        if (orderDO == null) {
            return null;
        }
        Order order = orderConvert.toDomain(orderDO);

        // 查询订单商品信息
        List<OrderItem> orderItems = orderItemMapper.selectList(new LambdaQueryWrapper<OrderItemDO>().eq(OrderItemDO::getOrderId, id))
                .stream().map(orderItemConvert::toDomain).collect(Collectors.toList());
        order.setOrderItems(orderItems);

        // 查询订单收货地址信息
        LambdaQueryWrapper<OrderShippingAddressDO> shippingAddressQryWp = new LambdaQueryWrapper<OrderShippingAddressDO>()
                .eq(OrderShippingAddressDO::getOrderId, id);
        order.setOrderShippingAddress(orderShippingAddressConvert.toDomain(orderShippingAddressMapper.selectOne(shippingAddressQryWp)));

        return order;
    }

}
