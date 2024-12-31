package com.gexingw.mall.order.infrastructure.repository;

import com.gexingw.mall.common.core.support.*;
import com.gexingw.mall.common.core.util.DiffUtil;
import com.gexingw.mall.domain.gateway.order.OrderGateway;
import com.gexingw.mall.domain.gateway.order.OrderItemGateway;
import com.gexingw.mall.domain.gateway.order.OrderShippingAddressGateway;
import com.gexingw.mall.domain.model.order.Order;
import com.gexingw.mall.domain.model.order.OrderItem;
import com.gexingw.mall.domain.model.order.OrderShippingAddress;
import com.gexingw.mall.domain.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import top.gexingw.ddd.core.AggregateManager;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author GeXingW
 */
@Repository
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class OrderRepositoryImpl extends DbRepository<Order, Long> implements OrderRepository {

    private final OrderGateway orderGateway;
    private final OrderItemGateway orderItemGateway;
    private final OrderShippingAddressGateway orderShippingAddressGateway;

    protected AggregateManager<Order, Long> aggregationManager = new ThreadLocalAggregationManager<>();

    @Override
    protected @Nullable Order select(@NotNull Long id) {
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

    @NotNull
    @Override
    protected Boolean insert(@NotNull Order order) {
        // 保存订单主信息
        Long orderId = orderGateway.insert(order);
        order.setId(orderId);

        // 保存订单商品信息
        for (OrderItem item : order.getItems()) {
            if (orderItemGateway.insert(item.setOrderId(orderId)) == 0) {
                throw new RuntimeException("订单保存失败！");
            }
        }

        // 保存收货地址信息
        if (orderShippingAddressGateway.save(order.getShippingAddress().setOrderId(orderId)) == 0) {
            throw new RuntimeException("订单保存失败！");
        }

        return true;
    }

    @NotNull
    @Override
    protected Boolean update(@NotNull Order order) {
        Order snapshot = this.find(order.getId());

        Map<String, List<DiffChange>> changes = DiffUtil.diff(snapshot, order);

        // 订单变更
        List<DiffChange> orderChanges = changes.getOrDefault(Order.class.getName(), Collections.emptyList());
        if (!orderChanges.isEmpty()) {
            if (!orderGateway.update(order)) {
                throw new RuntimeException("订单信息保存失败！");
            }
        }

        // 收货地址变更
        List<DiffChange> shippingAddressChanges = changes.getOrDefault(OrderShippingAddress.class.getName(), Collections.emptyList());
        for (DiffChange change : shippingAddressChanges) {
            if (change instanceof RemoveChange) {
                OrderShippingAddress orderShippingAddress = (OrderShippingAddress) change.getOldValue();
                if (!orderShippingAddressGateway.delete(orderShippingAddress.getId())) {
                    throw new RuntimeException("订单收货地址信息保存失败！");
                }
            }

            if (change instanceof NewChange) {
                OrderShippingAddress newShippingAddress = (OrderShippingAddress) change.getNewValue();
                if (orderShippingAddressGateway.save(newShippingAddress) == null) {
                    throw new RuntimeException("订单收货地址保存失败！");
                }
            }
        }

        return true;
    }

    @NotNull
    @Override
    protected Boolean delete(@NotNull Order order) {
        // 删除订单信息
        if (!orderGateway.delete(order.getId())) {
            return false;
        }

        // 删除订单商品信息
        Set<Long> orderItemIds = order.getItems().stream().map(OrderItem::getId).collect(Collectors.toSet());
        if (!orderItemGateway.delete(orderItemIds)) {
            return false;
        }

        // 删除订单收货地址信息
        Long orderShippingAddressId = order.getShippingAddress().getId();
        return orderShippingAddressGateway.delete(orderShippingAddressId);
    }

    @Override
    public @NotNull AggregateManager<Order, Long> getAggregationManager() {
        return this.aggregationManager;
    }

}
