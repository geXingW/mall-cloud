package com.gexingw.mall.domain.order.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/6 16:30
 */
public class OrderFactory {


    public static Order createOrder(List<OrderItem> items, OrderShippingAddress orderShippingAddress) {
        Order order = new Order().setOrderItems(items).setOrderShippingAddress(orderShippingAddress);

        // 商品总金额
        BigDecimal itemTotalAmount = items.stream().map(OrderItem::getTotalAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        order.setTotalAmount(itemTotalAmount);

        // 订单号
        order.setNumber(UUID.randomUUID().toString());

        // 订单状态

        return order;
    }

}
