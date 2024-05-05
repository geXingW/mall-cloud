package com.gexingw.mall.order.infrastructure.repository;

import com.gexingw.mall.domain.gateway.order.OrderGateway;
import com.gexingw.mall.domain.gateway.order.OrderItemGateway;
import com.gexingw.mall.domain.gateway.order.OrderShippingAddressGateway;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.domain.model.order.OrderItem;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GeXingW
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderGateway orderGateway;
    private final OrderItemGateway orderItemGateway;
    private final OrderShippingAddressGateway orderShippingAddressGateway;

    @Override
    public Order find(Long id) {
        // 查询订单主信息
        Order order = orderGateway.selectById(id);
        if (order == null) {
            return null;
        }

        // 查询订单商品信息
        List<OrderItem> orderItems = orderItemGateway.queryByOrderId(id);
        order.setItems(orderItems);

        // 收货地址信息
        OrderShippingAddress orderShippingAddress = orderShippingAddressGateway.getByOrderId(id);
        order.setShippingAddress(orderShippingAddress);

        return order;
    }

    @Override
    public Boolean remove(Order aggregate) {
        return null;
    }

    @Override
    @Transactional
    public Boolean save(Order order) {
        // 保存订单主信息
        Long orderId = orderGateway.insert(order);
        order.setId(orderId);

        // 保存订单商品信息
        for (OrderItem item : order.getItems()) {
            if (orderItemGateway.insert(item) == 0) {
                throw new RuntimeException("订单保存失败！");
            }
        }

        // 保存收货地址信息
        if (orderShippingAddressGateway.save(order.getShippingAddress()) == 0) {
            throw new RuntimeException("订单保存失败！");
        }

        return true;
    }

}
